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

	public List<TeamDetails> retrieveRegisteredTeamBasedOnTournamentID(long tournamentId) {
		String sql = "SELECT teamdetails.name, teamdetails.area FROM teamdetails INNER JOIN tournamentregistrationdetail ON tournamentregistrationdetail.teamId=teamdetails.teamId WHERE tournamentregistrationdetail.tournamentId="
				+ tournamentId;
		Query query = getSessionFactory().openSession().createSQLQuery(sql);
		List<TeamDetails> results = query.list();
		getSessionFactory().close();
		return results;
	}

}
