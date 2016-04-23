package com.coeuz.cricbounz.dao;

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
	public List<TeamDetails> getMyTeamsById(long userId)
	{
		//TeamDetails team1=(TeamDetails)get(userId);
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(TeamDetails.class);
		//cr.add(Restrictions.or(Restrictions.ilike("name", text, MatchMode.ANYWHERE)))));
		Session teamSession = getSessionFactory().openSession();
		//String teamHql ="FROM TeamDetails t WHERE t.players like '%,"+userId+",'%";
		String teamHql ="FROM TeamDetails t WHERE t.players like '%,"+userId+",%'";
		Query query= session.createQuery(teamHql);
		session.close();
		List<TeamDetails> teamLists =query.list();
		return teamLists;
	}
	
	public List<UserDetails> getTeamMembersByTeamId(long teamId)
	{
		TeamDetails team=(TeamDetails)get(teamId);
		String[] playerIds = team.getPlayers().split(",");
		Session session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(UserDetails.class);
		cr.add(Restrictions.in("userId", playerIds));
		List<UserDetails> userDetails = cr.list();
		return userDetails;
	}

}
