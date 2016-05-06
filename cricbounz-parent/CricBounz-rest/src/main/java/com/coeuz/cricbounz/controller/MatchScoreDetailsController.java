package com.coeuz.cricbounz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.dao.LiveActionDAO;
import com.coeuz.cricbounz.dao.MatchDetailsDAO;
import com.coeuz.cricbounz.model.Matches;
import com.coeuz.cricbounz.model.ResponseStatus;

@Controller
@RequestMapping(value = "/rest/score")
public class MatchScoreDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(MatchDetailsController.class);

	@Autowired
	private MatchDetailsDAO matchDetailsDAO;

	@Autowired
	LiveActionDAO playersinActionDAO;

	@RequestMapping(value = "/savescoredetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveMatchDetails(@RequestBody Matches matchDetails) {
		logger.info("Start scoring Details method");
		ResponseStatus responseStatus = new ResponseStatus();
		matchDetailsDAO.saveMatchDetails(matchDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/updatescoredetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus updateMatchDetails(@RequestBody Matches matchDetails) {
		logger.info("Start scoring Details method");
		ResponseStatus responseStatus = new ResponseStatus();
		matchDetailsDAO.updateMatchDetails(matchDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
}
