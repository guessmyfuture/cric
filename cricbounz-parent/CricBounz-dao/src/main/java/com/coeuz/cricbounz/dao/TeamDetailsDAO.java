package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.TeamDetails;

@Repository
public class TeamDetailsDAO extends BaseDAO<TeamDetails, Integer> {

	@Autowired
	public TeamDetailsDAO(SessionFactory sessionFactory) {
		super(TeamDetails.class);
		super.setSessionFactory(sessionFactory);
		
	}


	public TeamDetails getTeamDetails(long teamId) {
		TeamDetails teamType = null;
		teamType = (TeamDetails) get(teamId);
		return teamType;
	}
}
