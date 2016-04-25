package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.RequestNotifications;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UtilUserDetails;
@Repository
public class RequestNotificationDAO extends BaseDAO<RequestNotifications, Integer>{
	
	@Autowired
	TeamDAO teamDAO;
	
	@Autowired
	TeamDetails teamDetails;
	
	@Autowired
	UserDAO userDAO;
			
	@Autowired
	public RequestNotificationDAO(SessionFactory sessionFactory) {
		super(RequestNotifications.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public List<RequestNotifications> getNotificationDetails(long userID) throws SQLException,NullPointerException,ClassCastException {
		List<RequestNotifications> requestNotificationsList;
		Session session =getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		UserDetails userDetails =(UserDetails)session.get(UserDetails.class,userID); 
		String reqNotificationHql="FROM RequestNotifications r WHERE r.notifyToID="+userID+" order by timeStamp desc";
		Query reqNotificationQuery= session.createQuery(reqNotificationHql);
		requestNotificationsList  =(List<RequestNotifications>)reqNotificationQuery.list();
		if(requestNotificationsList!=null&&requestNotificationsList.size()>0){
			for(RequestNotifications requestNotifications:requestNotificationsList){
				requestNotifications.setUtilUserDetails(new UtilUserDetails());
				requestNotifications.getUtilUserDetails().setUserID(userID);	
				requestNotifications.getUtilUserDetails().setUserImage(userDetails.getProfileImageUrl());
				requestNotifications.getUtilUserDetails().setUserName(userDetails.getName());
			}
		}
		return requestNotificationsList;
    }
	
	
	

}
