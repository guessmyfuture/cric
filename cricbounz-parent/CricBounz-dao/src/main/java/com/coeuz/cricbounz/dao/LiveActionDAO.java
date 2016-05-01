package com.coeuz.cricbounz.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.LiveAction;
import com.coeuz.cricbounz.model.PlayingEleven;

@Repository
public class LiveActionDAO extends BaseDAO<LiveAction, Integer> {
	private Session session;

	@Autowired
	public LiveActionDAO(SessionFactory sessionFactory) {
		super(LiveAction.class);
		super.setSessionFactory(sessionFactory);

	}

	public void savePlayersinAction(LiveAction playersinAction) throws NullPointerException, SQLException {
		saveorUpdate(playersinAction);
	}

	public LiveAction getPlayersinAction(long playersinActionId) {
		LiveAction playersinAction = (LiveAction) get(playersinActionId);
		return playersinAction;
	}

	public List<LiveAction> checkForPlayerAvailability(List<PlayingEleven> playing11)
	{
		session = getSessionFactory().openSession();
		List players = new ArrayList();
		for(PlayingEleven p11 : playing11)
		{
		for(long l : p11.getPlayers())
		{
			players.add(l);
		}
		}
		Criteria cr = session.createCriteria(LiveAction.class);
		cr.add(Restrictions.in("playerId", players));
		return cr.list();
	}
	public void updatePlayingEleven(List<PlayingEleven> playing11)
	{
		session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		for(PlayingEleven p11 : playing11)
		{
		for(long l : p11.getPlayers())
		{
			LiveAction la = new LiveAction();
			la.setPlayerId(l);
			session.save(la);
		}
		}
		session.flush();
		session.clear();
		tx.commit();
		session.close();
	}
}
