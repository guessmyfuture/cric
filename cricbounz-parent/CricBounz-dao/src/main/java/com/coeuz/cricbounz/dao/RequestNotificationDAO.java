package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.RequestNotifications;
@Repository
public class RequestNotificationDAO extends BaseDAO<RequestNotifications, Integer>{
		
	@Autowired
	public RequestNotificationDAO(SessionFactory sessionFactory) {
		super(RequestNotifications.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public List<RequestNotifications> getNotificationDetails(long userID) throws SQLException,NullPointerException,ClassCastException {
	
		
		
		
	 return null;
    }
	
	
	

}
