package com.coeuz.cricbounz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.dao.CommentDAO;
import com.coeuz.cricbounz.dao.PostDAO;
import com.coeuz.cricbounz.dao.ShareDAO;
import com.coeuz.cricbounz.dao.UserDAO;
import com.coeuz.cricbounz.model.CommentDetails;
import com.coeuz.cricbounz.model.PostDetails;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.ShareDetails;
import com.coeuz.cricbounz.model.UserDetails;

@Controller
@RequestMapping(value="/rest/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private ShareDAO shareDAO;
	
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

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public @ResponseBody UserDetails getUserdetails(@RequestParam("userid") long userId) {
		logger.info("Start getUserdetails user details.");
		UserDetails userDetails = userDAO.getUserDetails(userId);
		return userDetails;
	}
	
	@RequestMapping(value = "/savepost", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus savePost(@RequestBody PostDetails postDetails) {
		logger.info("Start savepost.");
		ResponseStatus responseStatus = new ResponseStatus();
		postDAO.savePostDetails(postDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/getPostDetails", method = RequestMethod.GET)
	public @ResponseBody List<PostDetails> getPostDetails(HttpServletRequest request) {
		logger.info("Start getPostDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		Long userId = (Long)request.getSession().getAttribute("userId");
		List<PostDetails> postdetailsList = postDAO.getPostDetails(userId);
		responseStatus.setResponseStatus("Success");
		return postdetailsList;
	}
	
	@RequestMapping(value = "/deletepost", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus deletepostDetails(HttpServletRequest request,@RequestBody PostDetails postDetails) {
		logger.info("Start deletepostDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		Long userId = (Long)request.getSession().getAttribute("userId");
		postDetails.setPostedUserId(userId);
		postDetails.setStatus("D");
		postDAO.deletePostDetails(postDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/savecomment", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveComment(@RequestBody CommentDetails commentDetails) {
		logger.info("Start saveComment");
		ResponseStatus responseStatus = new ResponseStatus();
		commentDAO.saveCommentDetails(commentDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	
	@RequestMapping(value = "/deletecomment", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus deleteComment(HttpServletRequest request, @RequestBody CommentDetails commentDetails) {
		logger.info("Start deletecomment");
		ResponseStatus responseStatus = new ResponseStatus();
		Long userId = (Long)request.getSession().getAttribute("userId");
		commentDetails.setCommentedById(userId);
		commentDetails.setStatus("D");
		commentDAO.saveCommentDetails(commentDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	
	@RequestMapping(value = "/savesharedetail", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveSharedetail(@RequestBody ShareDetails shareDetails) {
		logger.info("Start saveSharedetails");
		ResponseStatus responseStatus = new ResponseStatus();
		shareDAO.saveShareDetails(shareDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	@RequestMapping(value = "/deletesharedetail", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus delteSharedetail(HttpServletRequest request,@RequestBody ShareDetails shareDetails) {
		logger.info("Start deletesharedetail");
		ResponseStatus responseStatus = new ResponseStatus();
		Long userId = (Long)request.getSession().getAttribute("userId");
		shareDetails.setSharedById(userId);
		shareDetails.setStatus("D");
		shareDAO.saveShareDetails(shareDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
	
	
	@RequestMapping(value = "/likeandunlike", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveLikeAndUnlike(@RequestBody PostDetails postDetails) {
		logger.info("Start saveLikeAndUnlike");
		ResponseStatus responseStatus = new ResponseStatus();
		String status = postDAO.saveLikeAndUnlike(postDetails);
		responseStatus.setResponseStatus(status);
		return responseStatus;
	}

}
