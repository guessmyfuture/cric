package com.coeuz.cricbounz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coeuz.cricbounz.dao.TeamStatusChangeDAO;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.TeamDetails;
import com.coeuz.cricbounz.model.TeamStatusChange;
import com.coeuz.cricbounz.model.Tournament;
import com.coeuz.cricbounz.model.UserDetails;

@Controller
@RequestMapping(value = "/rest/teamstatus")
public class TeamStatusChangeController {

	@Autowired
	private TeamStatusChangeDAO teamStatusChangeDAO;

	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus teamstatuschange(@RequestParam("userId") long userId,
			@RequestParam("tournamentId") long tournamentId, @RequestParam("teamId") long teamId)

	{

		ResponseStatus responseStatus = new ResponseStatus();
		Tournament tournament = new Tournament();
		UserDetails userdetails = new UserDetails();
		TeamDetails teamdetails = new TeamDetails();
		TeamStatusChange teamStatusChange = new TeamStatusChange();
		long userId1 = userdetails.getUserId();
		long tournamentId1 = tournament.getId();
		long teamId1 = teamdetails.getTeamID();
		teamStatusChange.setOrganizerID(userId1);
		teamStatusChange.setTeamId(teamId1);
		teamStatusChange.setTournamentId(tournamentId1);
		teamStatusChange.setStatus("a");
		teamStatusChangeDAO.saveTeamStatusChange(teamStatusChange);
		responseStatus.setResponseStatus("sucess");
		return responseStatus;
	}

}
