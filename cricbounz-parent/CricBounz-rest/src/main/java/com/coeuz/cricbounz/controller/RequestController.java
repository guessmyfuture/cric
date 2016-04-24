package com.coeuz.cricbounz.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coeuz.cricbounz.dao.FriendRequestDAO;
import com.coeuz.cricbounz.dao.MatchRequestDAO;
import com.coeuz.cricbounz.model.FriendRequest;
import com.coeuz.cricbounz.model.MatchRequest;
import com.coeuz.cricbounz.model.ResponseStatus;


@Controller
@RequestMapping(value = "/rest/request")
public class RequestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
	@Autowired
	private MatchRequestDAO matchRequestDAO;
	
	@Autowired
	private FriendRequestDAO friendRequestDAO;
	
	@RequestMapping(value = "/savematchreq", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveMatchRequest(@RequestBody MatchRequest matchRequest) {
		logger.info("Starting saveMatchRequest");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			matchRequestDAO.saveMatchRequest(matchRequest);
		}catch(SQLException sqlex){
			responseStatus.setErrorMessage("SQLException exception occured at saveMatchRequest");
			logger.error("SQLException exception occured at saveMatchRequest()"+sqlex);
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("NullPointerException exception occured at saveMatchRequest");
			logger.error("NullPointerException exception occured at saveMatchRequest()"+nullexp);
		}
		responseStatus.setResponseStatus("MatchrequestSavedSuccessfully");
		return responseStatus;
	}
	
	@RequestMapping(value = "/savefriendreq", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveFriendRequest(@RequestBody FriendRequest FriendRequest) {
		logger.info("Starting saveFriendRequest");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			friendRequestDAO.saveFriendRequest(FriendRequest);
		}catch(SQLException sqlex){
			responseStatus.setErrorMessage("SQLException exception occured at saveFriendRequest");
			logger.error("SQLException exception occured at saveFriendRequest()"+sqlex);
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("NullPointerException exception occured at saveFriendRequest");
			logger.error("NullPointerException exception occured at saveFriendRequest()"+nullexp);
		}
		responseStatus.setResponseStatus("FriedRequestSavedSuccessfully");
		return responseStatus;
	}
	
	
	/*@RequestMapping(value = "/getrequestmatchiddetails", method = RequestMethod.GET)
	public @ResponseBody RequestMatch getRequestMatchidDetails(@RequestParam("Id") long Id) {
		logger.info("Starting getRequestMatchidDetails");
		RequestMatch requestmatch = requestmatchDAO. getRequestMatchidDetails(Id);
		return requestmatch;
	}
	
	@RequestMapping(value = "/friendrequest", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus friendRequest(@RequestBody FriendRequest friendrequest) {
		logger.info("Starting friendRequest");
		ResponseStatus responseStatus = new ResponseStatus();
		friendRequestDAO.createfriendRequest(friendrequest);		
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

@RequestMapping(value = "/getrequestiddetails", method = RequestMethod.GET)
public @ResponseBody FriendRequest getFriendRequestidDetails(@RequestParam("fiendReqId") long fiendReqId) {
	logger.info("Starting getRequestMatchidDetails");
	FriendRequest friendrequest = friendRequestDAO. getFriendRequestidDetails(fiendReqId);
	return friendrequest;
}*/
}
