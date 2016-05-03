package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Value;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.GroundBookingDetails;
import com.coeuz.cricbounz.model.GroundBookingHistory;
import com.coeuz.cricbounz.model.RequestNotifications;
import com.coeuz.cricbounz.model.Slots;

@Repository
public class GroundBookingDetailsDAO extends BaseDAO<GroundBookingDetails, Integer> {

	private Session session;
	
	public static String Request_Type = "GROUND_BOOKING";
	public static String New_Booking_request = "NEW_REQUEST";
	public static String BOOKING_REJECTED = "BOOKING_REJECTED";
	public static String CANCEL_BOOKING = "CANCEL";
	public static String BOOKING_CONFIRMED = "BOOKING_CONFIRMED";
	
	@Autowired
	private RequestNotificationDAO reqNotDAO;
	
	@Autowired
	private GroundDAO groundDAO;

	@Autowired
	public GroundBookingDetailsDAO(SessionFactory sessionFactory) {
		super(GroundBookingDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	
	public void confirmGroundBooking(long userId, long bookingId, String action) {
		session = getSessionFactory().openSession();
		Query q = session.createQuery("UPDATE GroundBookingDetails gbd set gbd.status = :booking_status WHERE gbd.bookingId = :booking_Id AND gbd.groundId IN "
				+ "(SELECT g.groundId from Ground g where g.manager = :managerId )");
		if(action.equals(BOOKING_CONFIRMED))
		{
		q.setParameter("booking_status", BOOKING_CONFIRMED);
		}
		else
		{
			q.setParameter("booking_status", BOOKING_REJECTED);
		}
		q.setParameter("booking_Id", bookingId);
		q.setParameter("managerId", userId);
		session.beginTransaction();
		q.executeUpdate();
		Criteria cre = session.createCriteria(GroundBookingDetails.class);
		cre.add(Restrictions.eq("bookingId", bookingId));
		List<GroundBookingDetails> gbdList = cre.list();
		
		GroundBookingDetails gbd = gbdList.get(0);
		RequestNotifications reqNotify = new RequestNotifications();
		reqNotify.setNotifyToID(gbd.getBookedBy());
		reqNotify.setRequestID(bookingId);
		reqNotify.setRequestStatus(action);
		reqNotify.setRequestType(Request_Type);
		reqNotify.setTimeStamp(new Date());
		session.save(reqNotify);
		session.flush();
		session.getTransaction().commit();
		session.close();
		

	}
	
	public void addGroundBookingDetails(GroundBookingDetails bookingDetails) {
		Date playingDate = convertStrToDate(bookingDetails.getPlayingDate(), TimeZone.getDefault().getID());
		bookingDetails.setDateOfPlay(playingDate);
		Date today = new Date();
		bookingDetails.setDateOfRequest(today);
		session = getSessionFactory().openSession();
		bookingDetails.setStatus(New_Booking_request);
		session.beginTransaction();
		session.save(bookingDetails);
		Ground ground = (Ground)session.get(Ground.class, bookingDetails.getGroundId());
		RequestNotifications reqNotify = new RequestNotifications();
		reqNotify.setNotifyToID(ground.getManager());
		reqNotify.setRequestID(bookingDetails.getId());
		reqNotify.setRequestStatus(New_Booking_request);
		reqNotify.setRequestType(Request_Type);
		reqNotify.setTimeStamp(new Date());
		session.save(reqNotify);
		session.flush();
		session.getTransaction().commit();
		session.close();

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
	
	public List<GroundBookingDetails> getMyGroundBookings(long userId) {
		session = getSessionFactory().openSession();
		String hql = "SELECT FROM GroundBookingDetails gbd WHERE gbd.groundId IN (SELECT g.groundId "
				+ "from Ground g WHERE g.manager = :user_Id)";
		Query q = session.createQuery(hql);
		q.setParameter("user_Id", userId);
		List<GroundBookingDetails> gb = q.list();
		return gb;
	}
	
	public List<GroundBookingDetails> getGroundBookInfo(long groundId, String date) {
		session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(GroundBookingDetails.class);
		cr.add(Restrictions.eq("groundId", groundId));
		Date serverDate = (Date) convertStrToDate(date, TimeZone.getDefault().getID());
		cr.add(Restrictions.eq("dateOfPlay", serverDate));
		List<GroundBookingDetails> gb = cr.list();
		return gb;
	}
	
	public void cancelBooking(long id)
	{
		delete(id);
	}
	
	public List<GroundBookingHistory> getBookingHistory(long userId)
	{
		session = getSessionFactory().openSession();
		String queryStr = "SELECT gbd.bookingId AS bookingId, gbd.groundId AS groundId, gbd.myTeam AS myTeamId, gbd.opponentTeam AS opponentTeamId, gbd.dateOfPlay AS dateOfPlay, "
				+ "gbd.dateOfRequest AS dateOfRequest, g.name AS groundName, g.city AS city, g.area AS area, b.ballType AS ballType, t.name AS opponent "
				+ "FROM GroundBookingDetails gbd, Ground g, BallTypeDetails b, TeamDetails t WHERE gbd.bookedBy =:user_Id AND g.groundId = gbd.groundId "
				+ "AND b.ballId = gbd.ballTypeId AND t.teamID = gbd.opponentTeam";
		Query q = session.createQuery(queryStr).setResultTransformer(Transformers.aliasToBean(GroundBookingHistory.class));
		q.setParameter("user_Id", userId);
		List<GroundBookingHistory> gb = q.list();
		
		return gb;
	}


	public List<Slots> getAvailableSlotsForGround(long groundId, String date, Ground ground) {
		List<Slots> slots = null;
		session = getSessionFactory().openSession();
		Criteria cr = session.createCriteria(GroundBookingDetails.class);
		Date serverDate = (Date) convertStrToDate(date, TimeZone.getDefault().getID());
		cr.add(Restrictions.eq("groundId", groundId));
		cr.add(Restrictions.eq("dateOfPlay", serverDate));
		List<GroundBookingDetails> gb = cr.list();
		session.close();
		if (gb == null || gb.isEmpty()) {
			return ground.getSlotsList();
		} else {
			slots = ground.getSlotsList();
			ArrayList<Long> slotIds = new ArrayList();
			if (gb.size() == slots.size()) {
				return null;
			} else {
				List tempSlots = new ArrayList();
				for (GroundBookingDetails bd : gb) {
					slotIds.add(bd.getSlotId());
				}
				tempSlots.addAll(slots);
				for (long bookedId : slotIds) {
					for (Slots l : slots)
					{
						if(l.getSlotId() == bookedId)
						{
							tempSlots.remove(l);
							break;
						}
					}

				}
				slots = tempSlots;
			}
		}
		return slots;
	}

}
