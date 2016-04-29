package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
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
	
	/*jai*/
	public List<UserDetails> getUsersByName(String text)
	{		
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);		
		cr.add(Restrictions.or(Restrictions.ilike("name", text, MatchMode.ANYWHERE),
				Restrictions.or((Restrictions.ilike("profileName", text, MatchMode.ANYWHERE)),
						(Restrictions.ilike("email", text, MatchMode.ANYWHERE)))));
	List<UserDetails> userLists = cr.list();		
		return userLists;
	}	
	
	public List<Map> getFriendsListDetailsByUserID(long userID) throws NumberFormatException , NullPointerException, ArrayIndexOutOfBoundsException, SQLException{
		List<Map> friendsListDetails = new ArrayList<Map>();
		UserDetails  userDetails = (UserDetails)get(userID);
		String userFriends = userDetails.getFriends();
		if(userFriends!=null){
			String [] userFriendsIDArray = userFriends.split(",");	
			for(String friendsID:userFriendsIDArray){
				if(friendsID.length()>0){
				UserDetails friednsDetails = get(Long.parseLong(friendsID));
				Map<String,String> freindsDetailsMap = new HashMap<String,String>();
				freindsDetailsMap.put("UserID",friendsID);
				freindsDetailsMap.put("Name", friednsDetails.getName());
				freindsDetailsMap.put("Area", friednsDetails.getArea());
				freindsDetailsMap.put("City", friednsDetails.getCity());
				freindsDetailsMap.put("BattingStyle", friednsDetails.getBattingStyle());
				freindsDetailsMap.put("BowlingStyle", friednsDetails.getBowlingStyle());
				freindsDetailsMap.put("BowlingType", friednsDetails.getBowlingType());
				friendsListDetails.add(freindsDetailsMap);
				}
			 }
		}
							
		return friendsListDetails;
		
	}
	
	
	
	
	
	
}
