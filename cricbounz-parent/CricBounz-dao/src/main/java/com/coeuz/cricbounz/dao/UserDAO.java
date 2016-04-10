package com.coeuz.cricbounz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.UserDetails;
@Repository
public class UserDAO extends BaseDAO <UserDetails, Integer> {

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

	public String getUserIdFromMail(String email)
	{
		String userId = "";
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);
		cr.add(Restrictions.eq("email", email));
		List results = cr.list();
		if(results.size() != 0)
		{
			UserDetails userDetails = (UserDetails)results.get(0);
			Long l = userDetails.getUserId();
			userId = l.toString();
		}
		return userId;
	}
		
	
}
