package com.coeuz.cricbounz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.model.CommentDetails;
import com.coeuz.cricbounz.model.PostDetails;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.dao.CommentDAO;
import com.coeuz.cricbounz.dao.PostDAO;
import com.coeuz.cricbounz.dao.UserDAO;
import com.coeuz.cricbounz.model.UserDetails;

@Controller
@RequestMapping(value = "/rest/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentDAO commentDAO;

	@Autowired
	ResponseStatus responseStatus;

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus registerUserdetails(@RequestBody UserDetails userDetails) {
		logger.info("Start registerUserdetails details.");
		ResponseStatus responseStatus = new ResponseStatus();
		userDAO.registerUserDetails(userDetails);
		responseStatus.setResponseStatus("Success");

		return responseStatus;
	}
	
	
	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	public @ResponseBody UserDetails getUserdetails(@PathVariable("id") long userId) {
		logger.info("Start getUserdetails user details.");
		UserDetails userDetails= userDAO.getUserDetails(userId);
		return userDetails;
	}
					
	@RequestMapping(value = "/registerpost", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus registerPost(@RequestBody PostDetails postDetails) {
		logger.info("Start registerPost.");
		ResponseStatus responseStatus = new ResponseStatus();
		postDAO.registerPostDetails(postDetails);
		responseStatus.setResponseStatus("Success");

		return responseStatus;
	}
	
	@RequestMapping(value = "/registercomment", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus registerComment(@RequestBody CommentDetails commentDetails) {
		logger.info("Start registerComment");
		ResponseStatus responseStatus = new ResponseStatus();
		commentDAO.registerCommentDetails(commentDetails);
		responseStatus.setResponseStatus("Success");

		return responseStatus;
	}
	
	

}
