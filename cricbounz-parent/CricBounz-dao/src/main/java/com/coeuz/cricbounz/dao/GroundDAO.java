package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;

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
		ground = save(ground);
		update(ground);
	}

	public Ground getGroundDetails(long groundId) {
		Ground ground = null;
		ground = (Ground) get(groundId);
		return ground;
	}
	
	public ArrayList<Ground> getAllGroundDetails() {
		ArrayList<Ground> ground = null;
		ground = (ArrayList<Ground>) getAll();
		return ground;
	}

	
}
