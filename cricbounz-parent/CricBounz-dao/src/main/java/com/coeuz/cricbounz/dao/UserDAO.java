package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.CommentDetails;
import com.coeuz.cricbounz.model.PostDetails;
import com.coeuz.cricbounz.model.UserDetails;
@Repository
public class UserDAO extends BaseDAO <UserDetails, Integer> {
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentDAO commentDAO;
	
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
		PostDetails postDetails = null;
		CommentDetails commentDetails= null;
		userDetails=(UserDetails)get(userId);
		if(userDetails!=null){
		long retrivedUid = userDetails.getId();
		
		}
		
		return userDetails;
	}
		
	
}
