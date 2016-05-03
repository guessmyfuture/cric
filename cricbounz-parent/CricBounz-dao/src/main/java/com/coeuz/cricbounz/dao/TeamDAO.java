package com.coeuz.cricbounz.dao;

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
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.GlobalSearch;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UtilUserDetails;

@Repository
public class TeamDAO extends BaseDAO<TeamDetails, Integer> {

	@Autowired
	UserDAO userDAO;

	private Session session;

	@Autowired
	public TeamDAO(SessionFactory sessionFactory) {
		super(TeamDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void registerTeamDetails(TeamDetails teamDetails) {
		saveorUpdate(teamDetails);
	}

	public List<TeamDetails> getTeamsByName(String text) {
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		cr.add(Restrictions.or(Restrictions.ilike("name", text, MatchMode.ANYWHERE),
				Restrictions.or((Restrictions.ilike("area", text, MatchMode.ANYWHERE)))));
		@SuppressWarnings("unchecked")
		List<TeamDetails> teamLists = cr.list();
		session.close();
		return teamLists;
	}

	public List<TeamDetails> getMyTeams(String userId) {
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		cr.add(Restrictions.ilike("players", userId, MatchMode.ANYWHERE));
		@SuppressWarnings("unchecked")
		List<TeamDetails> teamLists = cr.list();
		return teamLists;
	}

	public String getTeamName(long teamId) {
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		cr.add(Restrictions.eq("teamID", teamId));
		List<TeamDetails> teamLists = cr.list();
		return teamLists.get(0).getName();
	}

	public List<TeamDetails> getAllTeams(String text) {
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		if (!text.isEmpty()) {
			cr.add(Restrictions.ilike("name", text, MatchMode.ANYWHERE));
		}
		@SuppressWarnings("unchecked")
		List<TeamDetails> teamLists = cr.list();
		session.close();
		return teamLists;
	}

	public List<GlobalSearch> getTeamsForGlobalSearch(String text) {
		text = text.toLowerCase();
		Session session = getSessionFactory().openSession();
Query q = session
				.createQuery(
						"SELECT e.teamID AS id, e.name AS name" + " FROM TeamDetails e WHERE LOWER(e.name) like :text")
				.setResultTransformer(Transformers.aliasToBean(GlobalSearch.class));
		q.setParameter("text", "%" + text + "%");
		List<GlobalSearch> userLists = q.list();
		for (GlobalSearch a : userLists) {
			a.setType("TEAM");
		}
		return userLists;
	}

	public List<UserDetails> getTeamMembersByTeamId(long teamId) {
		Object[] playerIds = getPlayersIdFromTeamId(teamId).toArray();
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);
		cr.add(Restrictions.in("userId", playerIds));
		@SuppressWarnings("unchecked")
		List<UserDetails> userDetails = cr.list();
		session.close();
		return userDetails;
	}

	public List<String> getPlayersIdFromTeamId(long teamId) {
		TeamDetails team = (TeamDetails) get(teamId);
		String[] playerIds = team.getPlayers().split(",");
		List<String> playersList = new ArrayList<String>();
		for (String s : playerIds) {
			if (s.length() > 0) {
				playersList.add(s);
			}
		}
		return playersList;

	}

	public TeamDetails getTeamMembersFullDetailsByTeamId(long teamId) {
		List<UtilUserDetails> playersDetailsList = new ArrayList<UtilUserDetails>();
		TeamDetails teamDetails = get(teamId);
		List<String> retrievedPlayersList = getPlayersIdFromTeamId(teamId);
		for (String playerID : retrievedPlayersList) {
			Map<String, String> playerRoles = new HashMap<String, String>();
			UtilUserDetails utilUserDetails = new UtilUserDetails();
			UserDetails userDetails = (UserDetails) userDAO.get(Long.parseLong(playerID));
			utilUserDetails.setUserID(userDetails.getUserId());
			utilUserDetails.setUserImage(userDetails.getProfileImageUrl());
			utilUserDetails.setUserName(userDetails.getName());
			if (userDetails.getBowlingStyle() != null) {
				playerRoles.put("BowlingStyle", userDetails.getBowlingStyle());
			}
			if (userDetails.getBattingStyle() != null) {
				playerRoles.put("BattingStyle", userDetails.getBattingStyle());
			}
			if (userDetails.getBowlingType() != null) {
				playerRoles.put("BowlingType", userDetails.getBowlingType());
			}
			utilUserDetails.setPlayesRoles(playerRoles);
			playersDetailsList.add(utilUserDetails);
		}
		teamDetails.setPlayesDetailsList(playersDetailsList);
		return teamDetails;
	}

	public List<Map<String, String>> getTeamDetails(long teamId) {
		List<Map<String, String>> detailsList = new ArrayList<Map<String, String>>();
		List<String> playersIds = getPlayersIdFromTeamId(teamId);
		for (String Id : playersIds) {
			UserDetails userDetails = (UserDetails) userDAO.get(Long.parseLong(Id));
			Map<String, String> utilUserDetails = new HashMap<String, String>();
			utilUserDetails.put("userName", userDetails.getName());
			utilUserDetails.put("userId", Long.toString(userDetails.getUserId()));
			utilUserDetails.put("userImage", userDetails.getProfileImageUrl());
			utilUserDetails.put("area", userDetails.getArea());
			utilUserDetails.put("city", userDetails.getCity());
			detailsList.add(utilUserDetails);
		}
		return detailsList;
	}

	public List<String> getAllCities() {
		List<String> cities = null;
		session = getSessionFactory().openSession();
		Query q = session.createQuery("SELECT DISTINCT city FROM TeamDetails");
		cities = q.list();
		return cities;
	}

	@SuppressWarnings("unchecked")
	public List<String> getAreaFromCityName(String city) {
		List<String> area = null;
		session = getSessionFactory().openSession();
		Query q = session.createQuery("SELECT DISTINCT area FROM TeamDetails where city = :city_name");
		q.setParameter("city_name", city);
		area = q.list();
		return area;
	}

	@SuppressWarnings("unchecked")
	public List<TeamDetails> getTeams(String city, String area) {
		List<TeamDetails> teams = null;
		session = getSessionFactory().openSession();
		Query q = session.createQuery("FROM TeamDetails where city = :city_name and area = :area_name");
		q.setParameter("city_name", city);
		q.setParameter("area_name", area);
		teams = q.list();
		return teams;
	}
}
