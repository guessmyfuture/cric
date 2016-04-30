package com.coeuz.cricbounz.dao;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.MatchinAction;

@Repository
public class MatchinActionDAO extends BaseDAO <MatchinAction, Integer> {

	@Autowired
	public MatchinActionDAO(SessionFactory sessionFactory) {
		super(MatchinAction.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public void saveMatchinaction(MatchinAction matchinAction) throws NullPointerException,SQLException{
		saveorUpdate(matchinAction);
	}

}
