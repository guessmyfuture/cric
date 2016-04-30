package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchScoreDetails;

@Repository
public class MatchDetailsControlDAO extends BaseDAO<MatchScoreDetails, Integer> {

	@Autowired
	public MatchDetailsControlDAO(SessionFactory sessionFactory) {
		super(MatchScoreDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void saveMatchDetails(MatchScoreDetails matchScoreDetails) {
		save(matchScoreDetails);
	}

	public MatchScoreDetails getMatchScoreDetails(long matchId) {
		MatchScoreDetails scoreDetails = null;
		scoreDetails = (MatchScoreDetails) get(matchId);
		return scoreDetails;
	}
	
	public void updateMatchDetails(MatchScoreDetails matchScoreDetails) {
		save(matchScoreDetails);
	}

}
