package com.coeuz.cricbounz.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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

import com.coeuz.cricbounz.dao.MatchDetailsDAO;
import com.coeuz.cricbounz.model.AbstractInnings;
import com.coeuz.cricbounz.model.Innings;
import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.ResponseStatus;

@Controller
@RequestMapping(value ="/rest/match")
public class MatchDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(MatchDetailsController.class);
	@Autowired
	private MatchDetailsDAO matchDetailsDAO;	
	
	@RequestMapping(value = "/createMatch", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus createMatchDetils(@RequestBody MatchDetails matchDetails){
		logger.info("Starting MatchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			matchDetailsDAO.save(matchDetails); 	
		}catch(NullPointerException |ClassCastException ex){
			responseStatus.setErrorMessage("Excpetion occured at createMatchDetils"+ex);
			logger.info("Excpetion occured at createMatchDetils"+ex);
			return responseStatus;
		}
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	@RequestMapping(value = "/createInnings", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus createInnings(@RequestBody AbstractInnings inningsAb){
		logger.info("Starting MatchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			long matchId = inningsAb.getMatchId();
			MatchDetails match = matchDetailsDAO.get(matchId);
			long batting = inningsAb.getBatting();
			long bowling = inningsAb.getBowling();
			Innings firstInnings = new Innings();
			firstInnings.setBattingTeam(batting);
			firstInnings.setBowlingTeam(bowling);
			firstInnings.setInningsType("FIRST");
			firstInnings.setMatchID(matchId);
			Innings secondInnings = new Innings();
			secondInnings.setBattingTeam(bowling);
			secondInnings.setBowlingTeam(batting);
			secondInnings.setInningsType("SECOND");
			secondInnings.setMatchID(matchId);
			List<Innings> innings = new ArrayList<Innings>();
			innings.add(firstInnings);
			innings.add(secondInnings);
			match.setInnings(innings);
			matchDetailsDAO.saveorUpdate(match);
		}catch(NullPointerException |ClassCastException ex){
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
		MatchDetails matchDetails = matchDetailsDAO.get(Id);
		return matchDetails;
	}
	
	

}
