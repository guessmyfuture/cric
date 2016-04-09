package com.coeuz.cricbounz.controller;

import java.util.List;

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
import com.coeuz.cricbounz.model.BallTypeDetails;
import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.GroundBookingDetails;
import com.coeuz.cricbounz.model.GroundSlots;
import com.coeuz.cricbounz.model.PitchTypeDetails;
import com.coeuz.cricbounz.model.ResponseStatus;

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
	private GroundSlotDAO groundSlotDAO;

	@Autowired
	private GroundBookingDetailsDAO groundBookingDetailsDAO;

	@Autowired
	ResponseStatus responseStatus;

	@RequestMapping(value = "/addground", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addGroundDetails(@RequestBody Ground ground) {
		logger.info("Starting addGroundDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		groundDAO.addGroundDetails(ground);
		responseStatus.setResponseStatus("Success");
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

	@RequestMapping(value = "/addslotdetails", method = RequestMethod.POST)
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
	}

	@RequestMapping(value = "/addgroundbookingdetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addGroundBookingDetails(@RequestBody GroundBookingDetails bookingDetails) {
		logger.info("Starting addGroundBookingDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		groundBookingDetailsDAO.addGroundBookingDetails(bookingDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getgroundbookingdetails", method = RequestMethod.GET)
	public @ResponseBody GroundBookingDetails getGroundBookingDetails(@RequestParam("bookingId") long bookingId) {
		logger.info("Starting getGroundBookingDetails");
		GroundBookingDetails groundBookingDetails = groundBookingDetailsDAO.getGroundBookingDetails(bookingId);
		return groundBookingDetails;
	}

	@RequestMapping(value = "/getavailableslots", method = RequestMethod.GET)
	public @ResponseBody List<GroundSlots> getAvailableSlotDetails(@RequestParam("groundId") long groundId,
			@RequestParam("date") long date) {
		logger.info("Starting getAvailableSlotDetails");
		List<GroundSlots> groundSlotDetails = groundSlotDAO.getAvailableGroundSlots(groundId, date);
		return groundSlotDetails;
	}

}
