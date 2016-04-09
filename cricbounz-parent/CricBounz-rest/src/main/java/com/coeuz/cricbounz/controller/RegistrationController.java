package com.coeuz.cricbounz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.dao.UserDAO;
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
	public @ResponseBody ResponseStatus registerUser(@RequestParam("email") String username, 
			@RequestParam("password") String password, @RequestParam("mobile") String mobile) {
		
		ResponseStatus responseStatus = new ResponseStatus();
		String user = username;
		String pwd = password;
		String contactNo = mobile;
		UserRegistration regUser = new UserRegistration();
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(username);
		userDetails.setMobile(mobile);
		regUser.setUsername(user);
		regUser.setPassword(pwd);
		regUser.setEnabled(1);
		regDAO.registerUser(regUser, userDetails);
		responseStatus.setResponseStatus("Success");

		return responseStatus;
	}
	
	
}
