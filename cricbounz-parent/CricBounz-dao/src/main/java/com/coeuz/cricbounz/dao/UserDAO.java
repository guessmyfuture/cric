package com.coeuz.cricbounz.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.UserDetails;
@Repository
public class UserDAO extends BaseDAO <UserDetails, Integer> {

	private Session session;
	private SessionFactory sessionFactory;
	
	
	@Autowired
    public UserDAO(SessionFactory sessionFactory) {
        super(UserDetails.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void registerUserDetails(UserDetails userDetails){
		saveorUpdate(userDetails);
	}
	
	public UserDetails getUserDetails(long userId){
		UserDetails userDetails = null;
		userDetails=(UserDetails)get(userId);
		return userDetails;
	}

	
		
	
}
