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

import com.coeuz.cricbounz.dao.MatchDetailsDAO;
import com.coeuz.cricbounz.dao.LiveActionDAO;
import com.coeuz.cricbounz.dao.TeamDAO;
import com.coeuz.cricbounz.dao.UserDAO;
import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.LiveAction;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.UserDetails;

@Controller
@RequestMapping(value = "/rest/score")
public class MatchScoreDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(MatchDetailsController.class);

	@Autowired
	private MatchDetailsDAO matchDetailsDAO;

	@Autowired
	private TeamDAO teamDAO;

	@Autowired
	LiveActionDAO playersinActionDAO;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/savescoredetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveMatchDetails(@RequestBody MatchDetails MatchDetails) {
		logger.info("Start scoring Details method");
		ResponseStatus responseStatus = new ResponseStatus();
		matchDetailsDAO.saveMatchDetails(MatchDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/updatescoredetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus updateMatchDetails(@RequestBody MatchDetails MatchDetails) {
		logger.info("Start scoring Details method");
		ResponseStatus responseStatus = new ResponseStatus();
		matchDetailsDAO.updateMatchDetails(MatchDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getMatchDetails", method = RequestMethod.GET)
	public @ResponseBody MatchDetails getMatchidDetails(@RequestParam("matchId") long matchId) {
		logger.info("Starting getMatchDetails");
		MatchDetails MatchDetails = matchDetailsDAO.getMatchDetails(matchId);
		return MatchDetails;
	}
}