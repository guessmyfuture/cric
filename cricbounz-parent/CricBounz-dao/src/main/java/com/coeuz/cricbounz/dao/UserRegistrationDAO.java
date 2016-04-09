package com.coeuz.cricbounz.dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UserRegistration;
@Component
public class UserRegistrationDAO  {

	@Autowired
	  private SessionFactory sessionFactory;
	@Autowired
	UserDAO userDAO;
		
	public void registerUser(UserRegistration reg, UserDetails useDtl){
	
		userDAO.save(useDtl);
		Session session = sessionFactory.openSession();
		String sqlquery = "INSERT INTO users(username, password, enabled)";
		Query query = session.createQuery(sqlquery);
		query.setParameter("username", reg.getUsername());
		query.setParameter("password", reg.getPassword());
		query.setParameter("enabled", 1);
        session.beginTransaction();
       query.executeUpdate();
       session.flush();
       session.getTransaction().commit();
		 
	}
	

}
