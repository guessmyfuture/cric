package com.coeuz.cricbounz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Tournament;

@Repository
public class TournamentDAO extends BaseDAO<Tournament, Integer> {
	@Autowired
	public TournamentDAO(SessionFactory sessionFactory) {
		super(Tournament.class);
        super.setSessionFactory(sessionFactory);
    }
	
	
	public void createTournament(Tournament tournament){
		save(tournament);
	}
	
	public List<Tournament> retrieveTournamentBasedOnStatus(String status){
		String hql = "FROM Tournament E WHERE E.status = '"+status+"'";
		Query query = getSessionFactory().openSession().createQuery(hql);
		List<Tournament> results = query.list();
		getSessionFactory().close();
		return results;
	}
	}
