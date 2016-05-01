package com.coeuz.cricbounz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.UserDetails;

@Repository
public class MatchDetailsDAO extends BaseDAO<MatchDetails, Integer> {

	private Session sess;

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

	public void updateMatchDetails(MatchDetails matchDetails) {
		update(matchDetails);
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
		return userDtl;	}
}
