package com.coeuz.cricbounz.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.TempMatchDetails;
import com.coeuz.cricbounz.model.UserDetails;

@Repository
public class MatchDetailsDAO extends BaseDAO<MatchDetails, Integer> {

	private Session sess;
	
	private static String MATCH_COMPLETED = "COMPLETED";
	
	@Autowired
	MatchinActionDAO matchDAO;

	@Autowired
	public MatchDetailsDAO(SessionFactory sessionFactory) {
		super(MatchDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void saveMatchDetails(MatchDetails matchDetails) {
		//matchDetails.setPlayingDate(convertStrToDate(matchDetails.getMatchDate(), TimeZone.getDefault().getID()));
		save(matchDetails);
	}

	public MatchDetails getMatchDetails(long matchId) {
		MatchDetails scoreDetails = null;
		scoreDetails = (MatchDetails) get(matchId);
		return scoreDetails;
	}

	public void updateMatchDetails(MatchDetails matchDetails) {
		update(matchDetails);
		if(matchDetails.getStatus().equals(MATCH_COMPLETED))
		{
			matchDAO.releaseLock(matchDetails.getMatchID());
		}
	}

	public void updateScorer(long scorer, long matchId) {
		sess = getSessionFactory().openSession();
		String hql = "UPDATE MatchDetails set scorer = :scorer " + "WHERE matchID = :matchId";
		Query query = sess.createQuery(hql);
		query.setParameter("scorer", scorer);
		query.setParameter("matchId", matchId);
		int result = query.executeUpdate();
	}
	
	public List<UserDetails> getNextBatsman(long inningsId)
	{
		sess = getSessionFactory().openSession();
		String hql = "FROM UserDetails user WHERE user.userId IN(SELECT b.batsmanId FROM BattingDetails b WHERE"
				+ " b.scoreDetailsId IN(SELECT s.scoreDetailsId FROM ScoreUpdate s WHERE s.inningsId = :inningsId )"
				+ " AND b.status = :status)";
		Query q = sess.createQuery(hql);
		q.setParameter("inningsId", inningsId);
		q.setParameter("status", null);
		List<UserDetails> userDtl = q.list();
		return userDtl;
	}
	
	public List<UserDetails> getNextBowler(long inningsId)
	{
		sess = getSessionFactory().openSession();
		String hql = "FROM UserDetails user WHERE user.userId IN(SELECT b.bowlerId FROM BowlingDetails b WHERE"
				+ " b.scoreDetailsId IN(SELECT s.scoreDetailsId FROM ScoreUpdate s WHERE s.inningsId = :inningsId )"
				+ " AND b.status = :status)";
		Query q = sess.createQuery(hql);
		q.setParameter("inningsId", inningsId);
		q.setParameter("status", null);
		List<UserDetails> userDtl = q.list();
		return userDtl;	
		}
	
	public List<MatchDetails> getUpcomingMatches(long userId)
	{
		sess = getSessionFactory().openSession();
		String hql = "SELECT ma.matchId, ma.teamAId as teamAID, ma.teamBId as teamBID, ma.city, ma.area, ma.venue, ma.playingDate, ma.overs, "
				+ "ma.matchType, ma.slot, ta.teamAName, tb.teamBName, tour.name as tournamentName FROM (SELECT t.name AS teamAName, t.teamID FROM TeamDetails t)ta, "
				+ "(SELECT t.name AS teamBName, t.teamID FROM TeamDetails t)tb, "
				+ "(SELECT m.matchID as matchId, m.teamAId, m.tournamentId, m.teamBId, m.city, m.area, m.venue, m.playingDate, m.overs, m.matchType, m.slot"
				+ " FROM MatchDetails m WHERE m.status = 'SCHEDULED' AND m.teamAId IN "
				+ "(SELECT t.teamID FROM TeamDetails t WHERE t.players LIKE '%,"+userId+",%') OR "
				+ "m.teamBId IN (SELECT t.teamID FROM TeamDetails t WHERE t.players LIKE '%,"+userId+",%')) ma, tournament tour "
				+ "WHERE ta.teamID = ma.teamAId OR tb.teamID = ma.teamBId OR tour.id = ma.tournamentId";
		Query q = sess.createSQLQuery(hql).setResultTransformer(Transformers.aliasToBean(TempMatchDetails.class));
		List<MatchDetails> matchDetails = q.list();
		return matchDetails;
	}
	
	public List<MatchDetails> getMyScoringMatches(long userId)
	{
		sess = getSessionFactory().openSession();
		Criteria cr = sess.createCriteria(MatchDetails.class);
		cr.add(Restrictions.eq("scorer", userId));
		return cr.list();
	}
	
	
	public void saveTournmentFixture(List<MatchDetails> matchDetailsList)
	{
		sess = getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		for(MatchDetails matchDetails : matchDetailsList)
		{
			sess.save(matchDetails);
		}
		sess.flush();
		sess.clear();
		tx.commit();
		sess.close();
	}
	
	
}
