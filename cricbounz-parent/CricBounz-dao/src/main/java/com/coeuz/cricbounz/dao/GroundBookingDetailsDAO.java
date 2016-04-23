package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.GroundBookingDetails;
import com.coeuz.cricbounz.model.GroundSlots;
import com.coeuz.cricbounz.model.Slots;

@Repository
public class GroundBookingDetailsDAO extends BaseDAO<GroundBookingDetails, Integer> {

	private Session session;

	@Autowired
	public GroundBookingDetailsDAO(SessionFactory sessionFactory) {
		super(GroundBookingDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	@Autowired
	private GroundSlotDAO groundSlotDAO;

	public void addGroundBookingDetails(GroundBookingDetails bookingDetails) {
		long slotId = bookingDetails.getSlotId();
		Date bookedDate = new Date();
		// slot.setStatus(0);
		saveorUpdate(bookingDetails);

	}

	public GroundBookingDetails getGroundBookingDetails(long bookingId) {
		GroundBookingDetails groundBookingDetails = null;
		groundBookingDetails = (GroundBookingDetails) get(bookingId);
		return groundBookingDetails;
	}

	public GroundBookingDetails getDetailsForSlotId(long slotId) {
		GroundBookingDetails bookingDetails = null;
		bookingDetails = (GroundBookingDetails) get(slotId);
		return bookingDetails;
	}

	public List<Slots> getAvailableSlotsForGround(long groundId, String date, Ground ground) {
		List<Slots> slots = null;
		session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(GroundBookingDetails.class);
		cr.add(Restrictions.eq("groundId", groundId));
		cr.add(Restrictions.eq("date", date));
		List<GroundBookingDetails> gb = cr.list();
		if (gb == null || gb.isEmpty()) {
			return ground.getSlotsList();
		} else {
			slots = ground.getSlotsList();
			ArrayList<Long> slotIds = new ArrayList();
			if (gb.size() == slots.size()) {
				return null;
			} else {
				for (GroundBookingDetails bd : gb) {
					slotIds.add(bd.getSlotId());
				}
				for (long bookedId : slotIds) {
					for (Slots l : slots)
					{
						if(l.getSlotId() == bookedId)
						{
							slots.remove(l);
							break;
						}
					}

				}
			}
		}
		return slots;
	}

}
