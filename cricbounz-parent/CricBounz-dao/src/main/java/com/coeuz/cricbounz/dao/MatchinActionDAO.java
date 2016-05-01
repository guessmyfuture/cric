package com.coeuz.cricbounz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.MatchinAction;

@Repository
public class MatchinActionDAO extends BaseDAO <MatchinAction, Integer> {

	private Session sess;
	@Autowired
	public MatchinActionDAO(SessionFactory sessionFactory) {
		super(MatchinAction.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public boolean checkMatchStatus(MatchDetails matchDetail)
	{
		boolean status = true;
		sess = getSessionFactory().openSession();
		Criteria cr = sess.createCriteria(MatchinAction.class);
		cr.add(Restrictions.or(Restrictions.eq("matchID", matchDetail.getMatchID()),
				Restrictions.or(Restrictions.eq("teamID", matchDetail.getTeamAId()), 
						Restrictions.eq("teamID", matchDetail.getTeamBId()))));
		List action = cr.list();
		if(action != null && action.isEmpty())
		{
			status = false;
		}
		return status;
	}
}
