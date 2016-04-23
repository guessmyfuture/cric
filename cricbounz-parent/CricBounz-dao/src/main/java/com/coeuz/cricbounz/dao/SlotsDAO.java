package com.coeuz.cricbounz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.CommentDetails;
import com.coeuz.cricbounz.model.PostDetails;
import com.coeuz.cricbounz.model.Slots;
@Repository
public class SlotsDAO extends BaseDAO <Slots, Integer> {
	private Session session;
	private SessionFactory sessionFactory;
	
	@Autowired
    public SlotsDAO(SessionFactory sessionFactory) {
        super(Slots.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void saveSlotsDetails(Slots slots){
		 saveorUpdate(slots);	
	}
	
	public Slots getSlotsDetails(long slotId){
		Slots slots=null;
		slots=(Slots)get(slotId);
		return slots; 
	}
	
	
	

}
