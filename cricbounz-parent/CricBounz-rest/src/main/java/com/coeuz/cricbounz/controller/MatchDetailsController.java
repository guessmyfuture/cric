package com.coeuz.cricbounz.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coeuz.cricbounz.dao.CreateMatchDetailsDAO;

import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.ResponseStatus;

@Controller
@RequestMapping(value ="/rest/matchdetails")
public class MatchDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(MatchDetailsController.class);
	@Autowired
	private CreateMatchDetailsDAO createMatchDetailsDAO;	
	
	@RequestMapping(value = "/creatematch", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus createMatchDetils(@RequestBody MatchDetails matchDetails){
		logger.info("Starting MatchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			createMatchDetailsDAO.createMatchDetails(matchDetails);  	
		}catch(SQLException | NullPointerException |ClassCastException ex){
			responseStatus.setErrorMessage("Excpetion occured at createMatchDetils"+ex);
			logger.info("Excpetion occured at createMatchDetils"+ex);
			return responseStatus;
		}
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	@RequestMapping(value = "/getmatchdetails", method = RequestMethod.GET)
	public @ResponseBody MatchDetails getMatchidDetails(@RequestParam("Id") long Id) {
		logger.info("Starting getMatchidDetails");
		MatchDetails matchDetails = createMatchDetailsDAO. getMatchidDetails(Id);
		return matchDetails;
	}
	
	

}
