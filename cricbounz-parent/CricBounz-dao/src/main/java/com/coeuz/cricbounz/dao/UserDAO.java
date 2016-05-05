package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.GlobalSearch;
import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UserRegistration;

@Repository
public class UserDAO extends BaseDAO<UserDetails, Integer> {

	@Autowired
	public UserDAO(SessionFactory sessionFactory) {
		super(UserDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void registerUserDetails(UserDetails userDetails) {
		saveorUpdate(userDetails);
	}

	public UserDetails getUserDetails(long userId) {
		UserDetails userDetails = null;
		userDetails = (UserDetails) get(userId);
		return userDetails;
	}

	public String getUserIdFromMail(String email) {
		String userId = "";
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);
		cr.add(Restrictions.eq("email", email));
		List results = cr.list();
		if (results.size() != 0) {
			UserDetails userDetails = (UserDetails) results.get(0);
			Long l = userDetails.getUserId();
			userId = l.toString();
		}
		return userId;
	}

	/* jai */
	public List<UserDetails> getUsersByName(String text) {
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);
		cr.add(Restrictions.or(Restrictions.ilike("name", text, MatchMode.ANYWHERE),
				Restrictions.or((Restrictions.ilike("profileName", text, MatchMode.ANYWHERE)),
						(Restrictions.ilike("email", text, MatchMode.ANYWHERE)))));
		List<UserDetails> userLists = cr.list();
		return userLists;
	}

	public List<GlobalSearch> getUsersForGlobalSearch(String text) {
		text = text.toLowerCase();
		Session session = getSessionFactory().openSession();
		Query q = session
				.createQuery("SELECT e.userId AS id, e.name AS name, e.profileImageUrl AS imageUrl"
						+ " FROM UserDetails e WHERE LOWER(e.name) like :text OR LOWER(e.profileName) like :text_profile"
						+ " OR LOWER(e.email) like :text_mail")
				.setResultTransformer(Transformers.aliasToBean(GlobalSearch.class));
		q.setParameter("text", "%" + text + "%");
		q.setParameter("text_profile", "%" + text + "%");
		q.setParameter("text_mail", "%" + text + "%");
		List<GlobalSearch> userLists = q.list();
		for (GlobalSearch a : userLists) {
			a.setType("USER");
		}
		return userLists;
	}

	public List<Map> getFriendsListDetailsByUserID(long userID)
			throws NumberFormatException, NullPointerException, ArrayIndexOutOfBoundsException, SQLException {
		List<Map> friendsListDetails = new ArrayList<Map>();
		UserDetails userDetails = (UserDetails) get(userID);
		String userFriends = userDetails.getFriends();
		if (userFriends != null) {
			String[] userFriendsIDArray = userFriends.split(",");
			for (String friendsID : userFriendsIDArray) {
				if (friendsID.length() > 0) {
					UserDetails friednsDetails = get(Long.parseLong(friendsID));
					Map<String, String> freindsDetailsMap = new HashMap<String, String>();
					freindsDetailsMap.put("UserID", friendsID);
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

	public List getUserNameFromUserIds(List userId) {
		Session session = getSessionFactory().openSession();
		String hql = "SELECT user.name AS name from UserDetails user WHERE user.userId IN (:user_Id)";
		Query q = session.createQuery(hql);
		q.setParameterList("user_Id", userId);
		return q.list();
	}

	public int changeCurrentPassword(long userID, String currPass,String newPass) {
		Session session = getSessionFactory().openSession();
		UserDetails userDetails = null;
		userDetails = (UserDetails) get(userID);
		String email =userDetails.getEmail();		
		String sql ="UPDATE users SET password='"+newPass+"' WHERE userName='"+email+"' AND  PASSWORD='"+currPass+"'";		
		SQLQuery sqlQuery=session.createSQLQuery(sql);
		int affectedCount=sqlQuery.executeUpdate();
		return affectedCount;
		
	}

		
}
