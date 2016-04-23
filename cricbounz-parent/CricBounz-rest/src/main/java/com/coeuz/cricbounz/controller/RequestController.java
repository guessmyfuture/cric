package com.coeuz.cricbounz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.dao.FriendRequestDAO;
import com.coeuz.cricbounz.dao.RequestMatchDAO;
import com.coeuz.cricbounz.model.FriendRequest;
import com.coeuz.cricbounz.model.RequestMatch;
import com.coeuz.cricbounz.model.ResponseStatus;



@Controller
@RequestMapping(value = "/rest/requestmatch")
public class RequestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
	@Autowired
	private RequestMatchDAO requestmatchDAO;
	
	@Autowired
	private FriendRequestDAO friendRequestDAO;
	
	@RequestMapping(value = "/details", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addNotificationsDetails(@RequestBody RequestMatch requestmatch) {
		logger.info("Starting addRequestMatchDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		requestmatchDAO.RequestMatchDetails(requestmatch);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	@RequestMapping(value = "/getrequestmatchiddetails", method = RequestMethod.GET)
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
}
}
