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

import com.coeuz.cricbounz.dao.MatchDetailsControlDAO;
import com.coeuz.cricbounz.dao.PlayersinActionDAO;
import com.coeuz.cricbounz.dao.TeamDAO;
import com.coeuz.cricbounz.dao.UserDAO;
import com.coeuz.cricbounz.model.MatchScoreDetails;
import com.coeuz.cricbounz.model.PlayersinAction;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.UserDetails;

@Controller
@RequestMapping(value = "/rest/match")
public class MatchScoreDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(MatchScoreDetailsController.class);

	@Autowired
	private MatchDetailsControlDAO matchDetailsControlDAO;

	@Autowired
	private TeamDAO teamDAO;

	@Autowired
	PlayersinActionDAO playersinActionDAO;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/savescoredetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveMatchScoreDetails(@RequestBody MatchScoreDetails matchScoreDetails) {
		logger.info("Start scoring Details method");
		ResponseStatus responseStatus = new ResponseStatus();
		matchDetailsControlDAO.saveMatchDetails(matchScoreDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/updatescoredetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus updateMatchScoreDetails(@RequestBody MatchScoreDetails matchScoreDetails) {
		logger.info("Start scoring Details method");
		ResponseStatus responseStatus = new ResponseStatus();
		matchDetailsControlDAO.updateMatchDetails(matchScoreDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getplayerslist", method = RequestMethod.GET)
	public @ResponseBody List<UserDetails> getTeamListByTeamID(HttpServletRequest request) {
		logger.info("Start getplayerslist ");
		UserDetails userDetails = null;
		List<UserDetails> userDetailsList = null;
		String userIdString = (String) request.getSession(false).getAttribute("userId");
		List<TeamDetails> teamDet = teamDAO.getMyTeams(userIdString);
		if (teamDet != null && !teamDet.isEmpty()) {
			for (TeamDetails teamDetails : teamDet) {
				List<String> userIdList = null;
				long teamId = teamDetails.getTeamID();
				userIdList = teamDAO.getPlayersIdFromTeamId(teamId);
				for(String userIDStr: userIdList){
					Long userId = Long.parseLong(userIDStr);	
					userDetails=userDAO.getUserDetails(userId);
					userDetailsList.add(userDetails);
				}
			
			}
		}
		return userDetailsList;
	}

	@RequestMapping(value = "/getmatchscoredetails", method = RequestMethod.GET)
	public @ResponseBody MatchScoreDetails getMatchidDetails(@RequestParam("matchId") long matchId) {
		logger.info("Starting getMatchScoreDetails");
		MatchScoreDetails matchScoreDetails = matchDetailsControlDAO.getMatchScoreDetails(matchId);
		return matchScoreDetails;
	}

	@RequestMapping(value = "/getplayerinaction", method = RequestMethod.GET)
	public @ResponseBody PlayersinAction getPlayersInAction(@RequestParam("playersinactionid") long playersInActionId) {
		logger.info("Starting getplayersinaction method");
		PlayersinAction playersInAction = playersinActionDAO.getPlayersinAction(playersInActionId);
		return playersInAction;
	}

	@RequestMapping(value = "/playersinactiondetails", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus savePlayersInAction(@RequestBody PlayersinAction playersInAction) {
		logger.info("Start players in action method");
		ResponseStatus responseStatus = new ResponseStatus();
		try {
			playersinActionDAO.savePlayersinAction(playersInAction);
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	

}
