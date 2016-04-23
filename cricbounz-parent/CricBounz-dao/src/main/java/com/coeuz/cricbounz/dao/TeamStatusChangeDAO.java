package com.coeuz.cricbounz.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.TeamStatusChange;
@Repository
public class TeamStatusChangeDAO extends BaseDAO <TeamStatusChange, Integer> {
	
	private Session session;
	@Autowired
    public TeamStatusChangeDAO(SessionFactory sessionFactory) {
        super(TeamStatusChange.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void saveTeamStatusChange(TeamStatusChange teamStatusChange){
		session = getSessionFactory().openSession();
		session.beginTransaction();
		String teamStatusChangeHql="UPDATE TeamStatusChange t set t.status='"+teamStatusChange.getStatus()+"' WHERE T.organizerID="+teamStatusChange.getOrganizerID();
		teamStatusChangeHql=teamStatusChangeHql+" AND t.tournamentId="+teamStatusChange.getTournamentId()+" AND t.teamId="+teamStatusChange.getTeamId();
		Query teamchangestatusQuery =session.createQuery(teamStatusChangeHql);
		teamchangestatusQuery.executeUpdate();
		session.flush();
		session.beginTransaction().commit();
		session.close();
	}

}
