package com.coeuz.cricbounz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.dao.LiveActionDAO;
import com.coeuz.cricbounz.dao.MatchDetailsDAO;
import com.coeuz.cricbounz.dao.MatchinActionDAO;
import com.coeuz.cricbounz.model.AbstractInnings;
import com.coeuz.cricbounz.model.BattingDetails;
import com.coeuz.cricbounz.model.BowlingDetails;
import com.coeuz.cricbounz.model.Innings;
import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.PlayingEleven;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.ScoreUpdate;
import com.coeuz.cricbounz.model.UserDetails;

@Controller
@RequestMapping(value = "/rest/match")
public class MatchDetailsController {
	
	private static String MATCH_CANCELLED = "CANCELLED";
	
	private static String MATCH_COMPLETED = "COMPLETED";
	
	private static String MATCH_SCHEDULED = "SCHEDULED";

	private static final Logger logger = LoggerFactory.getLogger(MatchDetailsController.class);
	@Autowired
	private MatchDetailsDAO matchDetailsDAO;
	
	private MatchinActionDAO matchAction;
	
	private LiveActionDAO liveaction;

	@RequestMapping(value = "/createMatch", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus createMatchDetils(@RequestBody MatchDetails matchDetails) {
		logger.info("Starting MatchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			matchDetails.setPlayingDate(new Date());
			matchDetails.setStatus(MATCH_SCHEDULED);
			matchDetailsDAO.save(matchDetails);
		} catch (NullPointerException | ClassCastException ex) {
			responseStatus.setErrorMessage("Excpetion occured at createMatchDetils" + ex);
			logger.info("Excpetion occured at createMatchDetils" + ex);
			return responseStatus;
		}
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/updateScorer", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus createMatchDetils(@RequestParam("scorerID") long scorer,
			@RequestParam("matchId") long matchId) {
		ResponseStatus responseStatus = new ResponseStatus();
		matchDetailsDAO.updateScorer(scorer, matchId);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/selectNextBatsman", method = RequestMethod.POST)
	public @ResponseBody List<UserDetails> getNextBatsman(@RequestParam("inningsId") long inningsId) {
		
		List<UserDetails> userDetails= matchDetailsDAO.getNextBatsman(inningsId);
		return userDetails;
	}
	
	@RequestMapping(value = "/selectNextBowler", method = RequestMethod.POST)
	public @ResponseBody List<UserDetails> getBowler(@RequestParam("inningId") long inningsId) {
		List<UserDetails> userDetails= matchDetailsDAO.getNextBowler(inningsId);
		return userDetails;
	}

	@RequestMapping(value = "/updatePlayingEleven", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus updatePlayingEleven(@RequestBody AbstractInnings inningsAb) {
		logger.info("Starting MatchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			long matchId = inningsAb.getMatchId();
			MatchDetails match = matchDetailsDAO.get(matchId);
			List<Innings> innings = match.getInnings();
			List<PlayingEleven> playing11 = inningsAb.getPlaying11();
			for (Innings in : innings)
			{
				ScoreUpdate sc = new ScoreUpdate();
				List<BattingDetails> batting = new ArrayList<BattingDetails>();
				List<BowlingDetails> bowling = new ArrayList<BowlingDetails>();
				for(PlayingEleven p11: playing11)
				{
					if(in.getBattingTeam()== p11.getTeamId())
					{
					  for(long id : p11.getPlayers())
					  {
						  BattingDetails bd = new BattingDetails();
						  bd.setBatsmanId(id);
						  batting.add(bd);
					  }
					}
					else 
					{
						for(long id : p11.getPlayers())
						  {
							  BowlingDetails bd = new BowlingDetails();
							  bd.setBowlerId(id);
							  bowling.add(bd);
						  }
					}
				}
				sc.setBattingDetails(batting);
				sc.setBowlingDetails(bowling);
				in.setScoreUpdate(sc);
			}
			
			matchDetailsDAO.saveorUpdate(match);
		} catch (NullPointerException | ClassCastException ex) {
			responseStatus.setErrorMessage("Excpetion occured in updating the Playing Eleven" + ex);
			logger.error("Excpetion occured in updating the Eleven's:" + ex);
			return responseStatus;
		}
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/createInnings", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus createInnings(HttpServletRequest request, @RequestBody AbstractInnings inningsAb) {
		logger.info("Starting MatchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		String id = (String) request.getSession(false).getAttribute("userId");
		id = id.trim();
		Long userId = Long.parseLong(id);
		try {
			long matchId = inningsAb.getMatchId();
			MatchDetails match = matchDetailsDAO.get(matchId);
			boolean status = matchAction.checkMatchStatus(match);
			if(status)
			{
			if(match.getScorer()== userId && match.getStatus().equals(MATCH_SCHEDULED))
			{
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
			}
			else
			{
				throw new AccessDeniedException("Match is not in Scheduled State"
						+ "OR You are not the Scorer for the Selected Match");
			}
			}
			else {
				throw new Exception("Match and Team are already in Action, "
						+ "a team cannot play two matches at a time");			
				}
		} catch (NullPointerException | ClassCastException ex) {
			responseStatus.setErrorMessage("Excpetion occured at createMatchDetils" + ex);
			logger.error("Excpetion occured at createMatchDetils" + ex);
			return responseStatus;
		}
		catch (AccessDeniedException ex) {
			responseStatus.setErrorMessage("Access Denied:" + ex);
			logger.error("Access Denied Exception for scoring the match");
			return responseStatus;
		}
		catch (Exception e)
		{
			responseStatus.setErrorMessage("Invalid Match and Team:" + e);
			logger.error("Match Cannot be Set in Action since two teams cannot play at the same time");
			return responseStatus;
		}
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getmatchdetails", method = RequestMethod.POST)
	public @ResponseBody MatchDetails getMatchidDetails(@RequestParam("matchId") long Id) {
		logger.info("Starting getMatchidDetails");
		MatchDetails matchDetails = matchDetailsDAO.get(Id);
		return matchDetails;
	}

}
