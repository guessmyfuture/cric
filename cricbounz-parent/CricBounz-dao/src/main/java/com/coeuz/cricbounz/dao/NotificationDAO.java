package com.coeuz.cricbounz.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.NotificationDetails;



@Repository
public class NotificationDAO extends BaseDAO<NotificationDetails,Integer> {

	@Autowired
	public NotificationDAO(SessionFactory sessionFactory) {
		super(NotificationDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void addNotificationDetails(NotificationDetails notificationdetails) {
		saveorUpdate(notificationdetails);
	}

}
