package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchDetails;

@Repository
public class CreateMatchDetailsDAO extends BaseDAO<MatchDetails, Integer> {
	@Autowired
	public CreateMatchDetailsDAO(SessionFactory sessionFactory) {
		super(MatchDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void createMatchDetails(MatchDetails matchDetails) {
		saveorUpdate(matchDetails);

	}
	public MatchDetails getMatchidDetails(long Id) {
		MatchDetails matchDetails = null;
		matchDetails = (MatchDetails) get(Id);
		return matchDetails;
	}
	
}
