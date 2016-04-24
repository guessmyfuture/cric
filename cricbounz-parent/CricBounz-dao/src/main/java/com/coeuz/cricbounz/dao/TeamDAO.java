package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;

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

@Repository
public class TeamDAO extends BaseDAO <TeamDetails, Integer> {
	
	@Autowired
    public TeamDAO(SessionFactory sessionFactory) {
        super(TeamDetails.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void registerTeamDetails(TeamDetails teamDetails){
		saveorUpdate(teamDetails);
	}
	/**/
	public List<TeamDetails> getTeamsByName(String text)
	{		
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		cr.add(Restrictions.or(Restrictions.ilike("name", text, MatchMode.ANYWHERE),
				Restrictions.or((Restrictions.ilike("area", text, MatchMode.ANYWHERE)))));
		List<TeamDetails> teamLists = cr.list();
		session.close();
		return teamLists;
	}
	public List<TeamDetails> getMyTeams(String userId)
	{
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		cr.add(Restrictions.ilike("players", userId, MatchMode.ANYWHERE));
		List<TeamDetails> teamLists =cr.list();
		session.close();
		return teamLists;
	}
	
	public List<UserDetails> getTeamMembersByTeamId(long teamId)
	{
		Object[] playerIds = getPlayersIdFromTeamId(teamId).toArray();
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);
		cr.add(Restrictions.in("userId", playerIds));
		List<UserDetails> userDetails = cr.list();
		return userDetails;
	}

	public List getPlayersIdFromTeamId(long teamId)
	{
		TeamDetails team=(TeamDetails)get(teamId);
		String[] playerIds = team.getPlayers().split(",");
		List playersList = new ArrayList();
		for (String s : playerIds)
		{
			long playerId = Long.parseLong(s.trim());
			playersList.add(playerId);
		}
		return playersList;
		
	}
}
