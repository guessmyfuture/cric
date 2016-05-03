package com.coeuz.cricbounz.controller;

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

import com.coeuz.cricbounz.dao.TeamDAO;
import com.coeuz.cricbounz.model.Ground;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.TeamDetails;

@Controller
@RequestMapping(value = "/rest/team")
public class TeamController {

	private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

	@Autowired
	private TeamDAO teamDAO;

	@RequestMapping(value = "/createteam", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus registerTeamDetails(HttpServletRequest request, @RequestBody TeamDetails teamDetails) {
		logger.info("Start registerTeamDetails method");
		ResponseStatus responseStatus = new ResponseStatus();
		String userIdStr = (String)request.getSession(false).getAttribute("userId");
		long userId = Long.parseLong(userIdStr.trim());
		teamDetails.setCreatedBy(userId);
		teamDAO.registerTeamDetails(teamDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/updateTeam", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus updateTeamDetails(@RequestBody TeamDetails teamDetails) {
		logger.info("Update Team Details");
		ResponseStatus responseStatus = new ResponseStatus();
		teamDAO.update(teamDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/deleteTeam", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus deleteTeam(@RequestParam("teamId") long teamId) {
		logger.info("Delete Team");
		ResponseStatus responseStatus = new ResponseStatus();
		teamDAO.delete(teamId);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/getMyTeams", method = RequestMethod.GET)
	public @ResponseBody List<TeamDetails> getMyTeams(HttpServletRequest request) {
		String userId = (String) request.getSession(false).getAttribute("userId");
		List<TeamDetails> teamDet = teamDAO.getMyTeams(userId);
		return teamDet;
	}
	
	@RequestMapping(value = "/getALLTeams", method = RequestMethod.GET)
	public @ResponseBody List<TeamDetails> getAllTeams(@RequestParam("searchText") String searchText) {
		String search = "" +searchText;
		List<TeamDetails> teamDet = teamDAO.getAllTeams(search);
		return teamDet;
	}

	@RequestMapping(value = "/getTeamFullDetails", method = RequestMethod.GET)
	public @ResponseBody TeamDetails getTeamMembersFullDetailsByTeamId(@RequestParam("teamId") long teamId) {
		TeamDetails teamDetails = teamDAO.getTeamMembersFullDetailsByTeamId(teamId);
		return teamDetails;
	}
	
	@RequestMapping(value = "/City", method = RequestMethod.GET)
	public @ResponseBody List<String> getAllCityName() {
		logger.info("Starting getting All City Names having Teams");
		List<String> cities = teamDAO.getAllCities();
		return cities;
	}
	
	@RequestMapping(value = "/City/Area", method = RequestMethod.GET)
	public @ResponseBody List<String> getAreaByCityName(@RequestParam("city") String cityName) {
		logger.info("Starting getting All Area Names having Team");
		List<String> cities = teamDAO.getAreaFromCityName(cityName);
		return cities;
	}
	
	@RequestMapping(value = "/getGrounds", method = RequestMethod.GET)
	public @ResponseBody List<TeamDetails> getTeams(@RequestParam("city") String cityName, 
			@RequestParam("area") String areaName) {
		List<TeamDetails> teams = teamDAO.getTeams(cityName, areaName);
		return teams;
	}

}
