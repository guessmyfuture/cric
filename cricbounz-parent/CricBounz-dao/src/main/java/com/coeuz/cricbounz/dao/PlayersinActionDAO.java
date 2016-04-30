package com.coeuz.cricbounz.dao;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.PlayersinAction;

@Repository
public class PlayersinActionDAO extends BaseDAO<PlayersinAction, Integer> {

	@Autowired
	public PlayersinActionDAO(SessionFactory sessionFactory) {
		super(PlayersinAction.class);
		super.setSessionFactory(sessionFactory);

	}

	public void savePlayersinAction(PlayersinAction playersinAction) throws NullPointerException, SQLException {
		saveorUpdate(playersinAction);
	}

	public PlayersinAction getPlayersinAction(long playersinActionId) {
		PlayersinAction playersinAction = (PlayersinAction) get(playersinActionId);
		return playersinAction;
	}

}
