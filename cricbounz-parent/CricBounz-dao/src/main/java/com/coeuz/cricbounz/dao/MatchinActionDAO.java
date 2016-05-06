package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
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

import com.coeuz.cricbounz.model.LiveMatches;
import com.coeuz.cricbounz.model.Matches;
import com.coeuz.cricbounz.model.MatchinAction;

@Repository
public class MatchinActionDAO extends BaseDAO <MatchinAction, Integer> {

	private Session sess;
	@Autowired
	public MatchinActionDAO(SessionFactory sessionFactory) {
		super(MatchinAction.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public boolean checkMatchStatus(Matches matchDetail)
	{
		boolean status = true;
		sess = getSessionFactory().openSession();
		List teams = new ArrayList(2);
		teams.add(matchDetail.getTeamAId());
		teams.add(matchDetail.getTeamBId());
		Criteria cr = sess.createCriteria(MatchinAction.class);
		cr.add(Restrictions.or(Restrictions.eq("matchID", matchDetail.getMatchID()),
				Restrictions.or(Restrictions.in("teamAID", teams), 
						Restrictions.in("teamBID", teams))));
		List action = cr.list();
		if(action != null && !action.isEmpty())
		{
			status = false;
		}
		if(status)
		{
			MatchinAction match = new MatchinAction();
			match.setMatchID(matchDetail.getMatchID());
			match.setTeamAID(matchDetail.getTeamAId());
			match.setTeamBID(matchDetail.getTeamBId());
			save(match);
		}
		return status;
	}
	public List<LiveMatches> liveMatches()
	{
		sess = getSessionFactory().openSession();
		String hql = "SELECT ma.matchID AS matchID, ma.teamAID AS teamAID, ma.teamBID AS teamBID, "
				+ "ta.name AS teamAName, tb.name AS teamBName FROM MatchinAction ma, "
				+ "(Select name from TeamDetails WHERE teamID = ma.teamAID) ta, "
				+ "(Select name from TeamDetails WHERE teamID = ma.teamBID) tb";
		Query q = sess.createQuery(hql).setResultTransformer(Transformers.aliasToBean(LiveMatches.class));
		List<LiveMatches> liveMatches = q.list();
		return liveMatches;
	}
	
	public void releaseLock(long matchId)
	{
		sess = getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		String hql = "DELETE FROM MatchinAction WHERE matchID = :match_ID";
		String hql1 = "DELETE FROM LiveAction la WHERE la.playerId IN(SELECT b.batsmanId FROM BattingDetails b "
				+ "WHERE b.scoreDetailsId IN (SELECT su.scoreDetailsId FROM ScoreUpdate su WHERE"
				+ " su.inningsId IN (SELECT in.inningsId FROM Innings in WHERE in.matchID = :match_ID)))";
		Query q = sess.createQuery(hql);
		q.setParameter("match_ID", matchId);
		Query q1 = sess.createQuery(hql);
		q1.setParameter("match_ID", matchId);
		q.executeUpdate();
		q1.executeUpdate();
		sess.flush();
		tx.commit();
		sess.close();
	}
}
