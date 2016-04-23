package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.Slots;

@Repository
public class GroundDAO extends BaseDAO<Ground, Integer> {
	
	@Autowired
	SlotsDAO slotsDAO;

	@Autowired
	public GroundDAO(SessionFactory sessionFactory) {
		super(Ground.class);
		super.setSessionFactory(sessionFactory);
	}

	public void addGroundDetails(Ground ground) {
		long groundID=saveAndRetrunUniqkey(ground);
		List<Slots> slotsList = ground.getSlotsList();
		for(Slots slots:slotsList){
			slots.setGroundId(groundID);
			slotsDAO.saveorUpdate(slots);	
		}
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
