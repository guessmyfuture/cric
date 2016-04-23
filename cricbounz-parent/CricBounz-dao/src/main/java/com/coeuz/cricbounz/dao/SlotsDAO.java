package com.coeuz.cricbounz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Slots;
@Repository
public class SlotsDAO extends BaseDAO <Slots, Integer> {
	private Session session;
	
	@Autowired
    public SlotsDAO(SessionFactory sessionFactory) {
        super(Slots.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void saveSlotsDetails(List<Slots> slotsList){
		 saveorUpdate(slotsList);	
	}
	
	public Slots getSlotsDetails(long slotId){
		Slots slots=null;
		slots=(Slots)get(slotId);
		return slots; 
	}
	public List<Slots> getAllSlots(long groundId)
	{
		List<Slots> slots = null;
		session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(Slots.class);
		cr.add(Restrictions.eq("groundId", groundId));
		slots = cr.list();
		session.close();
		return slots;
		
	}
	
	

}
