package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Ground;

@Repository
public class GroundDAO extends BaseDAO<Ground, Integer> {

	@Autowired
	public GroundDAO(SessionFactory sessionFactory) {
		super(Ground.class);
		super.setSessionFactory(sessionFactory);
	}

	public void addGroundDetails(Ground ground) {
		saveorUpdate(ground);
	}

	public Ground getGroundDetails(long groundId) {
		Ground ground = null;
		ground = (Ground) get(groundId);
		return ground;
	}

}
