package com.coeuz.cricbounz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.dao.UserRegistrationDAO;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UserRegistration;

@Controller
@RequestMapping(value = "/reg/user")
public class RegistrationController {	
	@Autowired
	UserRegistrationDAO regDAO;	
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus registerUser(@RequestBody UserRegistration usr) {
		
		ResponseStatus responseStatus = new ResponseStatus();
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(usr.getUsername());
		userDetails.setMobile(usr.getMobileNumber());
		usr.setEnabled(1);
		regDAO.registerUser(usr, userDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}	
	
}
