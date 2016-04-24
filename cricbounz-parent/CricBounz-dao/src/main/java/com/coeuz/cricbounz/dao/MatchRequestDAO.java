package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.MatchRequest;
import com.coeuz.cricbounz.model.RequestNotifications;
@Repository
public class MatchRequestDAO extends BaseDAO<MatchRequest, Integer>{
	@Autowired
	RequestNotificationDAO requestNotificationDAO;
	@Autowired
	RequestNotifications requestNotifications;
	
	@Autowired
	public MatchRequestDAO(SessionFactory sessionFactory) {
		super(MatchRequest.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public void saveMatchRequest(MatchRequest matchRequest) throws SQLException,NullPointerException{
		long matchreqID = saveAndRetrunUniqkey(matchRequest);
		if(matchreqID>0 && requestNotifications!=null){
			requestNotifications.setRequestID(matchreqID);
			requestNotifications.setRequestStatus(matchRequest.getRequestStatus());
			requestNotifications.setRequestType("MatchRequest");
			requestNotifications.setNotifyToID(matchRequest.getMatchRequestID());
			requestNotifications.setTimeStamp(new Date());
			requestNotificationDAO.saveorUpdate(requestNotifications);
		}
	}
	
	public void actionOnMatchRequest(MatchRequest matchRequest)throws SQLException,NullPointerException{
		
		
	 	
	 	
	   	
		
	}
	
	
}
