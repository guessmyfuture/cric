package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.FriendRequest;
import com.coeuz.cricbounz.model.RequestNotifications;
import com.coeuz.cricbounz.model.UserDetails;

@Repository
public class FriendRequestDAO extends BaseDAO<FriendRequest, Integer>{
	
	@Autowired
	RequestNotificationDAO requestNotificationDAO;
	@Autowired
	RequestNotifications requestNotifications;
		
	@Autowired
	public FriendRequestDAO(SessionFactory sessionFactory) {
		super(FriendRequest.class);
		super.setSessionFactory(sessionFactory);
    }

	public void saveFriendRequest(FriendRequest friendrequest) throws SQLException,NullPointerException,ClassCastException{
		long friendReqID = saveAndRetrunUniqkey(friendrequest);
		if(friendReqID>0 && requestNotifications!=null){
			requestNotifications.setReqNotificationID(0);
			requestNotifications.setRequestID(friendReqID);
			requestNotifications.setRequestStatus(friendrequest.getFriendReqStatus());
			requestNotifications.setRequestType("FriendRequest");
			requestNotifications.setNotifyToID(friendrequest.getRequestedTo());
			requestNotifications.setTimeStamp(new Date());
			requestNotificationDAO.saveorUpdate(requestNotifications);
		}
		
	}
	
	public void actionOnFriendRequest(FriendRequest friendrequest) throws SQLException,NullPointerException,ClassCastException{
		if(friendrequest.getFriendReqStatus().equals("accepted")){
			Session session = getSessionFactory().openSession();
			Transaction  transaction= session.beginTransaction();
			String userHql="FROM UserDetails u WHERE u.userId="+friendrequest.getRequestedTo();
			Query userQuery = session.createQuery(userHql);
			List<UserDetails> userList =(List<UserDetails>)userQuery.list();
			if(userList!=null&&userList.size()>0){
				UserDetails userDetails  = userList.get(0); 
				String userFriends = userDetails.getFriends();
				if(userFriends!=null&&userFriends.length()==0){
					userFriends=userFriends+","+friendrequest.getRequestedByID()+",";
				}else if(userFriends!=null&&userFriends.length()>0){
					userFriends=userFriends+friendrequest.getRequestedByID()+",";
				}
				
				String userFriendsAddHql="UPDATE UserDetails u SET u.friends=:friends WHERE u.userId=:userId";
				Query userFriendsAddQuery = session.createQuery(userFriendsAddHql);
				userFriendsAddQuery.setParameter("friends", userFriends);
				userFriendsAddQuery.setParameter("userId", friendrequest.getRequestedTo());
				userFriendsAddQuery.executeUpdate();
				String friendReqHql ="DELETE FROM FriendRequest  r WHERE r.fiendReqId=:fiendReqId";
				Query friendReqQuery = session.createQuery(friendReqHql);
				friendReqQuery.setParameter("fiendReqId", friendrequest.getFiendReqId());
				friendReqQuery.executeUpdate();
				String friendNotifyReqHql ="DELETE FROM RequestNotifications  r WHERE r.requestID=:requestID";
				Query friendNotifyQuery = session.createQuery(friendNotifyReqHql);
				friendNotifyQuery.setParameter("requestID",friendrequest.getFiendReqId());
				friendNotifyQuery.executeUpdate();
				session.flush();
				transaction.commit();
				session.close();
			}
		 }else if(friendrequest.getFriendReqStatus().equals("deleted")){
			Session session = getSessionFactory().openSession();
			Transaction  transaction= session.beginTransaction();
			delete(friendrequest.getFiendReqId());
			String friendReqHql ="DELETE FROM RequestNotifications  r WHERE r.requestID=:requestID";
			Query friendReqQuery = session.createQuery(friendReqHql);
			friendReqQuery.setParameter("requestID", friendrequest.getFiendReqId());
			friendReqQuery.executeUpdate();
			session.flush();
			transaction.commit();
			session.close(); 	 
		 }else if(friendrequest.getFriendReqStatus().equals("unfriend")){
			Session session = getSessionFactory().openSession();
			Transaction  transaction= session.beginTransaction();
			String userHql="FROM UserDetails u WHERE u.userId="+friendrequest.getRequestedTo();
			Query userQuery = session.createQuery(userHql);
			List<UserDetails> userList =(List<UserDetails>)userQuery.list();
			if(userList!=null&&userList.size()>0){
				UserDetails userDetails  = userList.get(0); 
				String userFriends = userDetails.getFriends();
				String delimit =",";
				if(userFriends!=null&&userFriends.length()>0){
				  StringTokenizer stringTokenizer = new StringTokenizer(userFriends,delimit);
				  String reconstructedfriends="";
				  while(stringTokenizer.hasMoreTokens()){
					String unfriendID = stringTokenizer.nextToken();
					long unfriendIDLong =(long)Long.parseLong(unfriendID);
					if(unfriendIDLong!=friendrequest.getRequestedByID()){
						if(reconstructedfriends.length()==0){
							reconstructedfriends=","+unfriendID+",";	
						}else if(reconstructedfriends!=null&&reconstructedfriends.length()>0){
							reconstructedfriends=reconstructedfriends+unfriendID+",";
						}
					}
					  
				  }
		    	
			String userFriendsAddedHql="UPDATE UserDetails u SET u.friends=:friends WHERE u.userId=:userId";
			Query userFriendsQuery = session.createQuery(userFriendsAddedHql);
			userFriendsQuery.setParameter("friends",reconstructedfriends);
			userFriendsQuery.setParameter("userId",friendrequest.getRequestedTo());
			userFriendsQuery.executeUpdate();
			session.flush();
			transaction.commit();
			session.close(); 	
				
			}
			 			 
		 }
			
	  }
			
					
  }
		
		
	
	
	

}
