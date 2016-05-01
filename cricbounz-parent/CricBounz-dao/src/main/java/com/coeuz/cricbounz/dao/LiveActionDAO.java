package com.coeuz.cricbounz.dao;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.LiveAction;

@Repository
public class LiveActionDAO extends BaseDAO<LiveAction, Integer> {

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

}
