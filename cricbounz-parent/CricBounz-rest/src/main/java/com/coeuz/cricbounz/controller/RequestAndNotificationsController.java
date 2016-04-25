package com.coeuz.cricbounz.controller;

import java.sql.SQLException;
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
import com.coeuz.cricbounz.dao.FriendRequestDAO;
import com.coeuz.cricbounz.dao.MatchRequestDAO;
import com.coeuz.cricbounz.dao.RequestNotificationDAO;
import com.coeuz.cricbounz.model.FriendRequest;
import com.coeuz.cricbounz.model.MatchRequest;
import com.coeuz.cricbounz.model.RequestNotifications;
import com.coeuz.cricbounz.model.ResponseStatus;

@Controller
@RequestMapping(value = "/rest/request")
public class RequestAndNotificationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestAndNotificationsController.class);
	@Autowired
	private MatchRequestDAO matchRequestDAO;
	
	@Autowired
	private FriendRequestDAO friendRequestDAO;
	
	@Autowired
	RequestNotificationDAO requestNotificationDAO;
	
	@RequestMapping(value = "/savematchreq", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveMatchRequest(@RequestBody MatchRequest matchRequest) {
		logger.info("Starting saveMatchRequest");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			matchRequestDAO.saveMatchRequest(matchRequest);
		}catch(SQLException sqlex){
			responseStatus.setErrorMessage("SQLException exception occured at saveMatchRequest");
			logger.error("SQLException exception occured at saveMatchRequest()"+sqlex);
			return responseStatus;
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("NullPointerException exception occured at saveMatchRequest");
			logger.error("NullPointerException exception occured at saveMatchRequest()"+nullexp);
			return responseStatus;
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
			return responseStatus;
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("NullPointerException exception occured at saveFriendRequest");
			logger.error("NullPointerException exception occured at saveFriendRequest()"+nullexp);
			return responseStatus;
		}
		responseStatus.setResponseStatus("FriedRequestSavedSuccessfully");
		return responseStatus;
	}
		
	@RequestMapping(value ="/actiononfriendreq", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus actionOnFriendRequest(@RequestBody FriendRequest FriendRequest) {
		logger.info("Starting actionOnFriendRequest");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			friendRequestDAO.actionOnFriendRequest(FriendRequest);
		}catch(SQLException sqlex){
			responseStatus.setErrorMessage("SQLException exception occured at actionOnFriendRequest");
			logger.error("SQLException exception occured at actionOnFriendRequest()"+sqlex);
			return responseStatus;
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("NullPointerException exception occured at actionOnFriendRequest");
			logger.error("NullPointerException exception occured at actionOnFriendRequest()"+nullexp);
			return responseStatus;
		}catch(ClassCastException classcsexp){
			responseStatus.setErrorMessage("ClassCastException exception occured at actionOnFriendRequest");
			logger.error("ClassCastException exception occured at actionOnFriendRequest()"+classcsexp);
			return responseStatus;
		}
		responseStatus.setResponseStatus("FriedRequestUpdatedSavedSuccessfully");
		return responseStatus;
	}
	
	@RequestMapping(value ="/actiononmatchreq", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus actionOnMatchRequest(@RequestBody MatchRequest matchRequest) {
		logger.info("Starting actionOnMatchRequest");
		ResponseStatus responseStatus = new ResponseStatus();
		try{
			matchRequestDAO.actionOnMatchRequest(matchRequest);
		}catch(SQLException sqlex){
			responseStatus.setErrorMessage("SQLException exception occured at actionOnMatchRequest");
			logger.error("SQLException exception occured at actionOnMatchRequest()"+sqlex);
			return responseStatus;
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("NullPointerException exception occured at actionOnMatchRequest");
			logger.error("NullPointerException exception occured at actionOnMatchRequest()"+nullexp);
			return responseStatus;
		}catch(ClassCastException classcsexp){
			responseStatus.setErrorMessage("ClassCastException exception occured at actionOnMatchRequest");
			logger.error("ClassCastException exception occured at actionOnMatchRequest()"+classcsexp);
			return responseStatus;
		}
		responseStatus.setResponseStatus("MatchRequestUpdatedSavedSuccessfully");
		return responseStatus;
	}
	
	@RequestMapping(value = "/getnotifications", method = RequestMethod.GET)
	public @ResponseBody List<RequestNotifications> getReqNotificationByUserID(@RequestParam("userid") long userId) {
		logger.info("Start getReqNotificationByUserID user details.");
		ResponseStatus responseStatus = new ResponseStatus();
		List<RequestNotifications> requestNotificationsList = null;
		try{
		requestNotificationsList= requestNotificationDAO.getNotificationDetails(userId);
		}catch(SQLException sqlex){
			responseStatus.setErrorMessage("SQLException exception occured at getReqNotificationByUserID");
			logger.error("SQLException exception occured at getReqNotificationByUserID()"+sqlex);
			
		}catch(NullPointerException nullexp){
			responseStatus.setErrorMessage("NullPointerException exception occured at getReqNotificationByUserID");
			logger.error("NullPointerException exception occured at getReqNotificationByUserID()"+nullexp);
		}catch(ClassCastException classcsexp){
			responseStatus.setErrorMessage("ClassCastException exception occured at getReqNotificationByUserID");
			logger.error("ClassCastException exception occured at getReqNotificationByUserID()"+classcsexp);
		}
		
		return requestNotificationsList;
	}	
	
	
		
}
