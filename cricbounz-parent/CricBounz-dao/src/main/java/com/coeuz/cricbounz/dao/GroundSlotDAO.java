package com.coeuz.cricbounz.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.GroundBookingDetails;
import com.coeuz.cricbounz.model.GroundSlots;

@Repository
public class GroundSlotDAO extends BaseDAO<GroundSlots, Integer> {
	private Session session;
	private SessionFactory sessionFactory;

	@Autowired
	public GroundSlotDAO(SessionFactory sessionFactory) {
		super(GroundSlots.class);
		super.setSessionFactory(sessionFactory);
	}

	public void addGroundSlotDetails(GroundSlots groundSlot) {
		saveorUpdate(groundSlot);
	}

	public GroundSlots getGroundSlotDetails(long slotId) {
		GroundSlots groundSlots = null;
		groundSlots = (GroundSlots) get(slotId);
		return groundSlots;
	}

	public List<GroundSlots> getAvailableGroundSlots(long groundId, long inputdate) {
		List<GroundSlots> slotDetails = new ArrayList<GroundSlots>();
		session = getSessionFactory().openSession();
		session.beginTransaction();
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
		String dateText = df2.format(new Date(inputdate));
		String slotsHql = "From GroundSlots g where g.groundId=" + groundId
				+ " and  g.status= 0 and g.status= 1 and  g.bookedDate ='" + dateText + "'";
		Query slotsQuery = session.createQuery(slotsHql);
		List<GroundSlots> groundSlotsList = (List<GroundSlots>) slotsQuery.list();
		if (groundSlotsList != null && groundSlotsList.size() > 0) {
			for (GroundSlots groundSlots : groundSlotsList) {
				if (groundSlots.getStatus() == 1) {
					slotDetails = getBookingDetails(groundSlots);
				} else {
					slotDetails.add(groundSlots);
				}
			}

		}
		return slotDetails;
	}

	private List<GroundSlots> getBookingDetails(GroundSlots groundSlots) {
		List<GroundSlots> availableSlotDetails = new ArrayList<GroundSlots>();
		GroundSlots slots = new GroundSlots();
		long slotId = groundSlots.getSlotId();
		String slots_1Hql = "From GroundBookingDetails b where g.slotId=" + slotId;
		Query slots_1Query = session.createQuery(slots_1Hql);
		List<GroundBookingDetails> groundBookingList = (List<GroundBookingDetails>) slots_1Query.list();
		if (groundBookingList != null && groundBookingList.size() > 0) {
			GroundBookingDetails bookingDetails = groundBookingList.get(0);
			slots.setSlotId(slotId);
			slots.setBookedBy(bookingDetails.getBookedBy());
			slots.setTeamAId(bookingDetails.getTeamAId());
			availableSlotDetails.add(slots);
		}
		return availableSlotDetails;
	}

}
