package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.TeamDetails;
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

}
