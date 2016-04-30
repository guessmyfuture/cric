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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UtilUserDetails;

@Repository
public class TeamDAO extends BaseDAO<TeamDetails, Integer> {

	@Autowired
	UserDAO userDAO;

	@Autowired
	public TeamDAO(SessionFactory sessionFactory) {
		super(TeamDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void registerTeamDetails(TeamDetails teamDetails) {
		saveorUpdate(teamDetails);
	}

	/**/
	public List<TeamDetails> getTeamsByName(String text) {
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		cr.add(Restrictions.or(Restrictions.ilike("name", text, MatchMode.ANYWHERE),
				Restrictions.or((Restrictions.ilike("area", text, MatchMode.ANYWHERE)))));
		List<TeamDetails> teamLists = cr.list();
		session.close();
		return teamLists;
	}

	public List<TeamDetails> getMyTeams(String userId) {
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		cr.add(Restrictions.ilike("players", userId, MatchMode.ANYWHERE));
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
		if(!text.isEmpty())
		{
		cr.add(Restrictions.ilike("name", text, MatchMode.ANYWHERE));
		}
		List<TeamDetails> teamLists = cr.list();
		session.close();
		return teamLists;
	}

	public List<UserDetails> getTeamMembersByTeamId(long teamId) {
		Object[] playerIds = getPlayersIdFromTeamId(teamId).toArray();
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);
		cr.add(Restrictions.in("userId", playerIds));
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

}
