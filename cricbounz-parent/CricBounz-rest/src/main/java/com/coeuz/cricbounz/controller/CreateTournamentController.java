package com.coeuz.cricbounz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coeuz.cricbounz.dao.CreateRegisteredTeamDAO;
import com.coeuz.cricbounz.dao.RegisterTournamentDAO;
import com.coeuz.cricbounz.dao.TournamentDAO;
import com.coeuz.cricbounz.model.MatchDetails;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.Tournament;
import com.coeuz.cricbounz.model.TournamentRegistrationDetail;

@Controller
@RequestMapping(value = "/tournament")
public class CreateTournamentController {

	@Autowired
	private TournamentDAO createTournamentDAO;

	@Autowired
	private RegisterTournamentDAO registerTournamentDAO;

	@Autowired
	private CreateRegisteredTeamDAO createRegisteredTeamDAO;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus createTournament(@RequestBody Tournament tournament) {
		ResponseStatus responseStatus = new ResponseStatus();
		createTournamentDAO.createTournament(tournament);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus registerTournament(HttpServletRequest request,
			@RequestParam long tournamentId) {
		ResponseStatus responseStatus = new ResponseStatus();
		String userIdAsString = (String) request.getSession(false).getAttribute("userId");
		TournamentRegistrationDetail tournamentRegistrationDetail = new TournamentRegistrationDetail();
		tournamentRegistrationDetail.setTournamentId(tournamentId);
		Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		tournamentRegistrationDetail.setRegistrationDate(sqlDate);
		tournamentRegistrationDetail.setRegistrationStatus("Requested");
		/*
		 * if(null != userIdAsString)
		 * tournamentRegistrationDetail.setUserId(Long.parseLong(userIdAsString)
		 * );
		 */
		registerTournamentDAO.registerTournament(tournamentRegistrationDetail);
		// TODO Retrieve user id from session and set it into user id variable.
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/retrievetournamentlist", method = RequestMethod.GET)
	public @ResponseBody List<Tournament> retrieveTournamentList(@RequestParam List<String> statusList) {
		List<Tournament> returnTournamentList = null;
		ListIterator<String> statusListIterator = statusList.listIterator();
		while (statusListIterator.hasNext()) {
			String status = statusListIterator.next();
			List<Tournament> resultList = createTournamentDAO.retrieveTournamentBasedOnStatus(status);
			if (returnTournamentList == null) {
				returnTournamentList = new ArrayList<Tournament>();
			}
			returnTournamentList.addAll(resultList);
		}
		return returnTournamentList;
	}

	@RequestMapping(value = "/retrieveregisteredteamlist", method = RequestMethod.GET)
	public @ResponseBody List<TeamDetails> retrieveregisteredteamList(@RequestParam String tournanamentId) {
		List<TeamDetails> returnregisteredteamList = null;
		List<TeamDetails> resultList = createRegisteredTeamDAO
				.retrieveRegisteredTeamBasedOnTournamentID(Long.parseLong(tournanamentId));
		if (returnregisteredteamList == null) {
			returnregisteredteamList = new ArrayList<TeamDetails>();
		}
		returnregisteredteamList.addAll(resultList);
		return returnregisteredteamList;
	}

	@RequestMapping(value = "/schedulematchesbyleague", method = RequestMethod.GET)
	public @ResponseBody Map<Integer, List<MatchDetails>> scheduleMatchesByLeague(@RequestParam String tournamentId,
			@RequestParam Integer noOfGroup, @RequestParam Integer countOfFaceToFace,
			@RequestParam String typeOfNextLevel) {

		List<TeamDetails> resultList = createRegisteredTeamDAO
				.retrieveRegisteredTeamBasedOnTournamentID(Long.parseLong(tournamentId));

		Integer teamCount = Integer.valueOf(resultList.size());
		Integer teamCountinGroup = teamCount / noOfGroup;
		Integer remainingTeamCount = teamCount % noOfGroup;
		Map<Integer, List<TeamDetails>> leaugeTeamDetails = new HashMap<Integer, List<TeamDetails>>();

		for (int i = 0; i < noOfGroup; i++) {

			Integer groupId = i;
			List<TeamDetails> teamDetails = new ArrayList<TeamDetails>();

			List<TeamDetails> resultListTemp = new ArrayList<TeamDetails>();
			resultListTemp.addAll(resultList);
			for (Iterator iterator = resultListTemp.iterator(); iterator.hasNext();) {
				TeamDetails teamDetail = (TeamDetails) iterator.next();
				teamDetails.add(teamDetail);
				resultList.remove(teamDetail);
				if (teamDetails.size() >= teamCountinGroup) {
					break;
				}
			}

			if (remainingTeamCount > 0) {
				for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
					TeamDetails teamDetail = (TeamDetails) iterator.next();
					teamDetails.add(teamDetail);
					resultList.remove(teamDetail);
					remainingTeamCount = remainingTeamCount - 1;
					break;
				}

			}
			leaugeTeamDetails.put(groupId, teamDetails);
		}

		Map<Integer, List<MatchDetails>> leaugeMatchDetails = new HashMap<Integer, List<MatchDetails>>();

		for (Integer groupId : leaugeTeamDetails.keySet()) {
			List<TeamDetails> teamDetails = leaugeTeamDetails.get(groupId);
			List<MatchDetails> matchDetails = new ArrayList<MatchDetails>();
			for (int i = 0; i < teamDetails.size(); i++) {
				for (int j = i + 1; j < teamDetails.size(); j++) {
					MatchDetails matchDetail = new MatchDetails();
					matchDetail.setTeamAId(teamDetails.get(i).getTeamID());
					matchDetail.setTeamBId(teamDetails.get(j).getTeamID());
					matchDetails.add(matchDetail);
				}
			}
			leaugeMatchDetails.put(groupId, matchDetails);
		}

		return leaugeMatchDetails;

	}

}
