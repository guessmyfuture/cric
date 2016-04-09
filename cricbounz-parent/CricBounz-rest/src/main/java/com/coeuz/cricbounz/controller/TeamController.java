package com.coeuz.cricbounz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coeuz.cricbounz.dao.TeamDAO;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.TeamDetails;

@Controller
@RequestMapping(value = "/rest/team")
public class TeamController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);
	
	@Autowired
	private TeamDAO teamDAO;
		
	@RequestMapping(value = "/teamdetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus registerTeamDetails(@RequestBody TeamDetails teamDetails) {
		logger.info("Start registerTeamDetails method");
		ResponseStatus responseStatus = new ResponseStatus();
		teamDAO.registerTeamDetails(teamDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
}
