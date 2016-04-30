package com.coeuz.cricbounz.dao;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchDetails;


@Repository
public class MatchDetailsDAO extends BaseDAO<MatchDetails, Integer> {
		
		
	@Autowired
	public MatchDetailsDAO(SessionFactory sessionFactory) {
		super(MatchDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void saveMatchDetails(MatchDetails MatchDetails) {
		save(MatchDetails);
	}

	public MatchDetails getMatchDetails(long matchId) {
		MatchDetails scoreDetails = null;
		scoreDetails = (MatchDetails) get(matchId);
		return scoreDetails;
	}
	
	public void updateMatchDetails(MatchDetails MatchDetails) {
		save(MatchDetails);
	}

}

