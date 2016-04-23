package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.TournamentRegistrationDetail;
@Repository
public class RegisterTournamentDAO extends BaseDAO<TournamentRegistrationDetail, Integer> {
	@Autowired
	public RegisterTournamentDAO(SessionFactory sessionFactory) {
		super(TournamentRegistrationDetail.class);
        super.setSessionFactory(sessionFactory);
    }
	
	
	public void registerTournament(TournamentRegistrationDetail tournamentRegistrationDetail){
		save(tournamentRegistrationDetail);
	}
	
	
	
	}
