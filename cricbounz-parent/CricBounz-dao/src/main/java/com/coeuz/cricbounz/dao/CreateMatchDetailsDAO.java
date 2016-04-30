package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.MatchinAction;
import com.coeuz.cricbounz.model.PlayersinAction;
import com.coeuz.cricbounz.model.TeamDetails;


@Repository
public class CreateMatchDetailsDAO extends BaseDAO<MatchDetails, Integer> {
		
		
	@Autowired
	public CreateMatchDetailsDAO(SessionFactory sessionFactory) {
		super(MatchDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void createMatchDetails(MatchDetails matchDetails) throws SQLException,NullPointerException,ClassCastException{
		saveorUpdate(matchDetails);
	}
	
	public MatchDetails getMatchidDetails(long Id) {
		MatchDetails matchDetails = null;
		matchDetails = (MatchDetails) get(Id);
		return matchDetails;
	}
		
}
