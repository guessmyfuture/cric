package com.coeuz.cricbounz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
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
	public @ResponseBody ResponseStatus registerTournament(@RequestParam long tournamentId) {
		ResponseStatus responseStatus = new ResponseStatus();
		TournamentRegistrationDetail tournamentRegistrationDetail = new TournamentRegistrationDetail();
		tournamentRegistrationDetail.setTournamentId(tournamentId);
		Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		tournamentRegistrationDetail.setRegistrationDate(sqlDate);
		tournamentRegistrationDetail.setRegistrationStatus("Requested");
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

}
