package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.MatchRequest;
import com.coeuz.cricbounz.model.RequestNotifications;
@Repository
public class MatchRequestDAO extends BaseDAO<MatchRequest, Integer>{
	@Autowired
	RequestNotificationDAO requestNotificationDAO;
	@Autowired
	RequestNotifications requestNotifications;
	@Autowired
	CreateMatchDetailsDAO createMatchDetailsDAO;
	@Autowired
	MatchDetails matchDetails;
	@Autowired
	TeamDAO teamDAO;
	
	@Autowired
	public MatchRequestDAO(SessionFactory sessionFactory) {
		super(MatchRequest.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public void saveMatchRequest(MatchRequest matchRequest) throws NullPointerException,SQLException,ClassCastException{
		long matchreqID = saveAndRetrunUniqkey(matchRequest);
		if(matchreqID>0 && requestNotifications!=null){
			List<String> playersList =teamDAO.getPlayersIdFromTeamId(matchRequest.getRequestedToTeam());
			for(String userID:playersList){
				requestNotifications.setReqNotificationID(0);
				requestNotifications.setRequestID(matchreqID);
				requestNotifications.setRequestStatus(matchRequest.getRequestStatus());
				requestNotifications.setRequestType("MatchRequest");
				long userIDLong=Long.parseLong(userID);
				requestNotifications.setNotifyToID(userIDLong);
				requestNotifications.setTimeStamp(new Date());
				requestNotificationDAO.saveorUpdate(requestNotifications);	
			}
		}
	}
	public MatchRequest getRequestMatchidDetails(long matchRequestId) {
		MatchRequest matchRequest = null;
		matchRequest = (MatchRequest) get(matchRequestId);
		return matchRequest;
	}
	
	public void actionOnMatchRequest(MatchRequest matchRequest)throws NullPointerException,SQLException,ClassCastException{
		
		if(matchRequest.getRequestStatus().equals("accepted")){
			MatchRequest retrievedmatchRequest = getRequestMatchidDetails(matchRequest.getMatchRequestID());
			if(retrievedmatchRequest.getOpponentTeamApprovalCount()<4){
				retrievedmatchRequest.setOpponentTeamApprovalCount(retrievedmatchRequest.getOpponentTeamApprovalCount()+1);
				deleteRequestnotification(matchRequest);
				saveorUpdate(retrievedmatchRequest);
								
			}else if(retrievedmatchRequest.getOpponentTeamApprovalCount()==4){
				matchDetails.setTeamAId(matchRequest.getRequestedByTeam());
				matchDetails.setTeamBId(matchRequest.getRequestedToTeam());
				matchDetails.setStatus("Sheduled");
				matchDetails.setTimestamp(new Date());
				long matchID = createMatchDetailsDAO.saveAndRetrunUniqkey(matchDetails);
				
				deleteRequestnotification(matchRequest);
								
				List<String> requestedByTeamplayersList =teamDAO.getPlayersIdFromTeamId(matchRequest.getRequestedByTeam());
				for(String requestedByTeamplayersID : requestedByTeamplayersList){
					requestNotifications.setReqNotificationID(0);
					requestNotifications.setRequestID(matchID);
					requestNotifications.setRequestStatus("MatchSheduled");
					requestNotifications.setRequestType("MatchSheduled");
					requestNotifications.setNotifyToID(Long.parseLong(requestedByTeamplayersID));
					requestNotifications.setTimeStamp(new Date());
					requestNotificationDAO.saveorUpdate(requestNotifications);
				}
				
				List<String> requestedToTeamplayersList =teamDAO.getPlayersIdFromTeamId(matchRequest.getRequestedToTeam());
				for(String requestedToTeamplayersID : requestedToTeamplayersList){
					requestNotifications.setReqNotificationID(0);
					requestNotifications.setRequestID(matchID);
					requestNotifications.setRequestStatus("MatchSheduled");
					requestNotifications.setRequestType("MatchSheduled");
					requestNotifications.setNotifyToID(Long.parseLong(requestedToTeamplayersID));
					requestNotifications.setTimeStamp(new Date());
					requestNotificationDAO.saveorUpdate(requestNotifications);
				}
				
				
			}
					
		}
		
	}
	
	private void deleteRequestnotification(MatchRequest matchRequest){
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String notificationHql="DELETE RequestNotifications r WHERE r.requestID="+matchRequest.getMatchRequestID()+" AND r.requestType='MatchRequest' AND r.notifyToID="+matchRequest.getRequestedToID();
		Query notificationQuery = session.createQuery(notificationHql);
		notificationQuery.executeUpdate();
		session.flush();
		transaction.commit();
		session.close();
	}
	
	
	
}
