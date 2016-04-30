package com.coeuz.cricbounz.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.dao.BallTypeDAO;
import com.coeuz.cricbounz.dao.GroundBookingDetailsDAO;
import com.coeuz.cricbounz.dao.GroundDAO;
import com.coeuz.cricbounz.dao.GroundSlotDAO;
import com.coeuz.cricbounz.dao.PitchTypeDAO;
import com.coeuz.cricbounz.dao.SlotsDAO;
import com.coeuz.cricbounz.dao.TeamDAO;
import com.coeuz.cricbounz.model.BallTypeDetails;
import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.GroundBookingDetails;
import com.coeuz.cricbounz.model.GroundBookingHistory;
import com.coeuz.cricbounz.model.GroundSlots;
import com.coeuz.cricbounz.model.PitchTypeDetails;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.Slots;

@Controller
@RequestMapping(value = "/rest/ground")
public class GroundController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private GroundDAO groundDAO;

	@Autowired
	private BallTypeDAO ballTypeDAO;

	@Autowired
	private PitchTypeDAO pitchTypeDAO;

	@Autowired
	private GroundBookingDetailsDAO groundBookingDetailsDAO;

	@Autowired
	ResponseStatus responseStatus;
	
	@Autowired 
	SlotsDAO slotsDAO;
	
	@Autowired 
	TeamDAO teamDAO;


	@RequestMapping(value = "/addground", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addGroundDetails(HttpServletRequest request, @RequestBody Ground ground) {
		logger.info("Starting addGroundDetails");
		String userIdStr = (String)request.getSession(false).getAttribute("userId");
		long userId = Long.parseLong(userIdStr.trim());
		ground.setManager(userId);
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			groundDAO.addGroundDetails(ground);
			responseStatus.setResponseStatus("Success");	
		}catch(SQLException sqlex){
			responseStatus.setErrorMessage("SQL Excception occured at addGroundDetails()");
			logger.error("SQL Excception occured at addGroundDetails()"+sqlex);
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("SQL Excception occured at addGroundDetails()");
			logger.error("NullPointerException Excception occured at addGroundDetails()"+nullexp);
		}
		responseStatus.setResponseStatus("Saved Successfully");
		return responseStatus;
	}

	@RequestMapping(value = "/getgrounddetails", method = RequestMethod.GET)
	public @ResponseBody Ground getGroundDetails(@RequestParam("groundId") long groundId) {
		logger.info("Starting getGroundDetails");
		Ground groundDetails = groundDAO.getGroundDetails(groundId);
		return groundDetails;
	}

	@RequestMapping(value = "/addballtype", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addBallDetails(@RequestBody BallTypeDetails ballTypeDetails) {
		logger.info("Starting addBallDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		ballTypeDAO.addBallTypeDetails(ballTypeDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/getAllBallTypes", method = RequestMethod.GET)
	public @ResponseBody BallTypeDetails getAllBallTypes(@RequestParam("ballId") long ballId) {
		logger.info("Starting getBallTypeDetails");
		BallTypeDetails ballTypeDetails = ballTypeDAO.getBallTypeDetails(ballId);
		return ballTypeDetails;
	}

	@RequestMapping(value = "/getballdetails", method = RequestMethod.GET)
	public @ResponseBody BallTypeDetails getBallTypeDetails(@RequestParam("ballId") long ballId) {
		logger.info("Starting getBallTypeDetails");
		BallTypeDetails ballTypeDetails = ballTypeDAO.getBallTypeDetails(ballId);
		return ballTypeDetails;
	}

	@RequestMapping(value = "/addpitchdetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addPitchDetails(@RequestBody PitchTypeDetails pitchTypeDetails) {
		logger.info("Starting addPitchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		pitchTypeDAO.addPitchTypeDetails(pitchTypeDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getpitchdetails", method = RequestMethod.GET)
	public @ResponseBody PitchTypeDetails getPitchTypeDetails(@RequestParam("pitchId") long pitchId) {
		logger.info("Starting getPitchTypeDetails");
		PitchTypeDetails pitchTypeDetails = pitchTypeDAO.getPitchTypeDetails(pitchId);
		return pitchTypeDetails;
	}

	/*@RequestMapping(value = "/addslotdetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addSlotDetails(@RequestBody GroundSlots groundSlots) {
		logger.info("Starting addSlotDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		groundSlotDAO.addGroundSlotDetails(groundSlots);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getslotdetails", method = RequestMethod.GET)
	public @ResponseBody GroundSlots getSlotDetails(@RequestParam("slotId") long slotId) {
		logger.info("Starting getSlotDetails");
		GroundSlots groundSlotDetails = groundSlotDAO.getGroundSlotDetails(slotId);
		return groundSlotDetails;
	}*/

	@RequestMapping(value = "/addgroundbookingdetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addGroundBookingDetails(HttpServletRequest request, @RequestBody GroundBookingDetails bookingDetails) {
		logger.info("Starting addGroundBookingDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		String userIdStr = (String)request.getSession(false).getAttribute("userId");
		long userId = Long.parseLong(userIdStr.trim());
		bookingDetails.setBookedBy(userId);
		groundBookingDetailsDAO.addGroundBookingDetails(bookingDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getBookingDetails", method = RequestMethod.GET)
	public @ResponseBody GroundBookingDetails getBookingDetails(@RequestParam("bookingId") long bookingId) {
		logger.info("Starting getGroundBookingDetails");
		GroundBookingDetails groundBookingDetails = groundBookingDetailsDAO.getGroundBookingDetails(bookingId);
		return groundBookingDetails;
	}
	
	@RequestMapping(value = "/getGroundBookings", method = RequestMethod.GET)
	public @ResponseBody List<GroundBookingDetails> getGroundBookInfo(@RequestParam("groundId") long groundId, 
			@RequestParam("date") String date) {
		logger.info("Starting getGroundBookingDetails");
		List<GroundBookingDetails> groundBookingDetails = groundBookingDetailsDAO.getGroundBookInfo(groundId, date);
		return groundBookingDetails;
	}
	
	@RequestMapping(value = "/CancelBooking", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus cancelBooking(@RequestParam("bookingId") long bookingId) {
		logger.info("Starting getGroundBookingDetails");
		groundBookingDetailsDAO.cancelBooking(bookingId);
		ResponseStatus res = new ResponseStatus();
		res.setResponseStatus("The Ground Slot Booking has been Cancelled Succesfully");
		return res;
	}
	
	@RequestMapping(value = "/myBookingHistory", method = RequestMethod.GET)
	public @ResponseBody List<GroundBookingHistory> getBookingHistory(HttpServletRequest request) {
		logger.info("Starting getGroundBookingDetails");
		String currentUser = (String)request.getSession(false).getAttribute("userId");
		long userId = Long.parseLong(currentUser.trim());
		List<GroundBookingHistory> groundBookingDetails = groundBookingDetailsDAO.getBookingHistory(userId);
		for(GroundBookingHistory gbh : groundBookingDetails)
		{
			gbh.setMyTeam(teamDAO.getTeamName(gbh.getMyTeamId()));
		}
		return groundBookingDetails;
	}

	@RequestMapping(value = "/getavailableslots", method = RequestMethod.GET)
	public @ResponseBody List<Slots> getAvailableSlotDetails(@RequestParam("groundId") long groundId,
			@RequestParam("date") String date) {
		logger.info("Starting getAvailableSlotDetails");
		Ground groundDetails = groundDAO.getGroundDetails(groundId);
		List<Slots> groundSlotDetails = groundBookingDetailsDAO.getAvailableSlotsForGround(groundId, date, groundDetails);
		return groundSlotDetails;
	}
	
	@RequestMapping(value = "/getallgrounds", method = RequestMethod.GET)
	public @ResponseBody List<Ground> getAllGrounds() {
		logger.info("Starting getting All Grround Details");
		List<Ground> allGround = groundDAO.getAllGroundDetails();
		return allGround;
	}
	
	@RequestMapping(value = "/City", method = RequestMethod.GET)
	public @ResponseBody List<String> getAllCityName() {
		logger.info("Starting getting All City Names having Grounds");
		List<String> cities = groundDAO.getAllCities();
		return cities;
	}
	
	@RequestMapping(value = "/City/Area", method = RequestMethod.GET)
	public @ResponseBody List<String> getAreaByCityName(@RequestParam("city") String cityName) {
		logger.info("Starting getting All City Names having Grounds");
		List<String> cities = groundDAO.getAreaFromCityName(cityName);
		return cities;
	}
	
	@RequestMapping(value = "/getGrounds", method = RequestMethod.GET)
	public @ResponseBody List<Ground> getGround(@RequestParam("city") String cityName, 
			@RequestParam("area") String areaName) {
		logger.info("Starting getting All City Names having Grounds");
		List<Ground> ground = groundDAO.getGrounds(cityName, areaName);
		return ground;
	}
	
	@RequestMapping(value = "/confirmGroundBooking", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus confirmGroundBooking(HttpServletRequest request, @RequestParam("bookingId") long bookingId, 
			@RequestParam("requestAction") String requestAction) {
		String userIdStr = (String)request.getSession(false).getAttribute("userId");
		long userId = Long.parseLong(userIdStr.trim());
		groundBookingDetailsDAO.confirmGroundBooking(userId, bookingId, requestAction);
		ResponseStatus res = new ResponseStatus();
		res.setResponseStatus("The Ground Slot Booking has been Confirmed");
		return res;
	}
}
