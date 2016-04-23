package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.Slots;

@Repository
public class GroundDAO extends BaseDAO<Ground, Integer> {
	
	@Autowired
	SlotsDAO slotsDAO;

	private Session session;
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
		List <Slots> slots = slotsDAO.getAllSlots(groundId);
		ground.setSlotsList(slots);
		return ground;
	}
	
	public ArrayList<Ground> getAllGroundDetails() {
		ArrayList<Ground> ground = null;
		ground = (ArrayList<Ground>) getAll();
		return ground;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getAllCities() {
		List<String> cities = null;
		session = getSessionFactory().openSession();
		Query q =session.createQuery("SELECT DISTINCT city FROM Ground");
		cities = q.list();
		session.close();
		return cities;
	}

	@SuppressWarnings("unchecked")
	public List<String> getAreaFromCityName(String city) {
		List<String> area = null;
		session = getSessionFactory().openSession();
		Query q =session.createQuery("SELECT DISTINCT area FROM Ground where city = :city_name");
		q.setParameter("city_name",city);
		area = q.list();
		session.close();
		return area;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ground> getGrounds(String city, String area) {
		List<Ground> grounds = null;
		session = getSessionFactory().openSession();
		Query q =session.createQuery("FROM Ground where city = :city_name and area = :area_name");
		q.setParameter("city_name", city);
		q.setParameter("area_name", area);
		grounds = q.list();
		session.close();
		return grounds;
	}
	
}
