package com.coeuz.cricbounz.dao;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.GroundBookingDetails;
import com.coeuz.cricbounz.model.GroundSlots;

@Repository
public class GroundBookingDetailsDAO extends BaseDAO <GroundBookingDetails, Integer> {

	@Autowired
    public GroundBookingDetailsDAO(SessionFactory sessionFactory) {
        super(GroundBookingDetails.class);
        super.setSessionFactory(sessionFactory);
    }
	
	@Autowired
	private GroundSlotDAO groundSlotDAO; 
	
	
	public void addGroundBookingDetails(GroundBookingDetails bookingDetails){
		long slotId=bookingDetails.getSlotId();
		GroundSlots slot = groundSlotDAO.getGroundSlotDetails(slotId);
		int status=+1;
		Date bookedDate = new Date();
		slot.setStatus(status);
		slot.setBookedDate(bookedDate);
		saveorUpdate(bookingDetails);
		
	}
	
	public GroundBookingDetails getGroundBookingDetails(long bookingId){
		GroundBookingDetails groundBookingDetails = null;
		groundBookingDetails =(GroundBookingDetails)get(bookingId);
		return groundBookingDetails;
	}
	
	public GroundBookingDetails getDetailsForSlotId(long slotId){
		GroundBookingDetails bookingDetails = null;
		bookingDetails =(GroundBookingDetails)get(slotId);
		return bookingDetails;
	}
	
}
