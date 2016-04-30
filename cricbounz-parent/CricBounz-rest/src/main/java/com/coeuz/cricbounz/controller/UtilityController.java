package com.coeuz.cricbounz.controller;

import java.sql.SQLException;
import java.util.List;

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
import com.coeuz.cricbounz.dao.UserDAO;
import com.coeuz.cricbounz.model.BallTypeDetails;
import com.coeuz.cricbounz.model.GlobalSearch;
import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.GroundBookingDetails;
import com.coeuz.cricbounz.model.PitchTypeDetails;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.Slots;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.UserDetails;

@Controller
@RequestMapping(value = "/rest/utility")
public class UtilityController {

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
	
	@Autowired 
	SlotsDAO slotsDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	TeamDAO teamDAO;

	@RequestMapping(value = "/addballtype", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addBallDetails(@RequestBody BallTypeDetails ballTypeDetails) {
		logger.info("Starting addBallDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		ballTypeDAO.addBallTypeDetails(ballTypeDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/globalSearch", method = RequestMethod.GET)
	public @ResponseBody List<GlobalSearch> getUsersAndTeams(@RequestParam("searchText") String text) {
		logger.info("Starting search");
		 List <GlobalSearch> userDtl = userDAO.getUsersForGlobalSearch(text);
		 List <GlobalSearch> teamDtl = teamDAO.getTeamsForGlobalSearch(text);
		 userDtl.addAll(teamDtl);
		return userDtl;
	}
	
	@RequestMapping(value = "/getAllBallTypes", method = RequestMethod.GET)
	public @ResponseBody List<BallTypeDetails> getAllBallTypes() {
		logger.info("Starting getBallTypeDetails");
		List<BallTypeDetails> ballTypeDetails = ballTypeDAO.getAll();
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
}
