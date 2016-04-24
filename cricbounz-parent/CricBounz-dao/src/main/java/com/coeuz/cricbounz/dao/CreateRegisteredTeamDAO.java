package com.coeuz.cricbounz.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.TournamentRegistrationDetail;

@Repository
public class CreateRegisteredTeamDAO extends BaseDAO<TournamentRegistrationDetail, Integer> {

	@Autowired

	public CreateRegisteredTeamDAO(SessionFactory sessionFactory) {
		super(TournamentRegistrationDetail.class);
		super.setSessionFactory(sessionFactory);
	}

	public void createTournamentRegistrationDetail(TournamentRegistrationDetail tournamentRegistrationDetail) {
		save(tournamentRegistrationDetail);
	}

	
	// Retrieve team ids from tournament registartion detail table and retrieve the team details of corresponding team ids from team details table
	public List<TeamDetails> retrieveRegisteredTeamBasedOnTournamentID(long tournamentId) {
		String sql = "FROM TeamDetails td WHERE td.teamID IN (Select trd.teamId FROM TournamentRegistrationDetail trd WHERE trd.tournamentId= :tour_Id  )";
		
		Query query = getSessionFactory().openSession().createQuery(sql);
		query.setParameter("tour_Id", tournamentId);
		List<TeamDetails> results = query.list();
		getSessionFactory().close();
		return results;
	}

}
