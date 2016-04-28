package com.coeuz.cricbounz.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
	public @ResponseBody UserDetails getUserdetailsByUserID(@RequestParam("userid") long userId) {
		logger.info("Start getUserdetailsByUserID user details.");
		UserDetails userDetails = userDAO.getUserDetails(userId);
		return userDetails;
	}

	@RequestMapping(value = "/getcurrentuser", method = RequestMethod.GET)
	public @ResponseBody UserDetails getCurrentUserdetailsByUserID(HttpServletRequest request) {
		logger.info("Start getCurrentUserdetailsByUserID user details.");
		System.out.println("Session Current User id :" + request.getSession().getAttribute("userId"));
		String id = (String) request.getSession(false).getAttribute("userId");
		id = id.trim();
		Long userId = Long.parseLong(id);
		UserDetails userDetails = userDAO.getUserDetails(userId);
		return userDetails;
	}

	@RequestMapping(value = "/savepost", method = RequestMethod.POST)
	public @ResponseBody PostDetails savePost(HttpServletRequest request, @RequestBody PostDetails postDetails) {
		logger.info("Start savepost.");
		String id = (String) request.getSession(false).getAttribute("userId");
		id = id.trim();
		Long userId = Long.parseLong(id);
		postDetails.setPostedUserId(userId);
		postDetails.setTimestamp(new Date());
		postDetails.setStatus("A");

		ResponseStatus responseStatus = new ResponseStatus();
		postDAO.savePostDetails(postDetails);
		responseStatus.setResponseStatus("Success");
		// return responseStatus;
		return postDetails;
	}

	@RequestMapping(value = "/getPostDetails", method = RequestMethod.GET)
	public @ResponseBody List<PostDetails> getPostDetails(HttpServletRequest request, @RequestParam("limit") int limit,
			@RequestParam("offset") int offset) {

		System.out.println("Lazy Loading-- Limit=" + limit + " Offset=" + offset);

		logger.info("Start getPostDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		String id = (String) request.getSession(false).getAttribute("userId");
		id = id.trim();
		Long userId = Long.parseLong(id);
		List<PostDetails> postdetailsList = postDAO.getPostDetails(userId, limit, offset);
		responseStatus.setResponseStatus("Success");
		return postdetailsList;
	}

	@RequestMapping(value = "/deletepost", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus deletepostDetails(HttpServletRequest request,
			@RequestBody PostDetails postDetails) {
		logger.info("Start deletepostDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		Long userId = (Long) request.getSession().getAttribute("userId");
		postDetails.setPostedUserId(userId);
		postDetails.setStatus("D");
		postDAO.deletePostDetails(postDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	/*
	 * @RequestMapping(value = "/savecomment", method = RequestMethod.POST)
	 * public @ResponseBody ResponseStatus saveComment(HttpServletRequest
	 * request,@RequestBody CommentDetails commentDetails) { logger.info(
	 * "Start saveComment"); ResponseStatus responseStatus = new
	 * ResponseStatus(); Long userId =
	 * (Long)request.getSession().getAttribute("userId");
	 * commentDetails.setCommentedById(userId);
	 * commentDAO.saveCommentDetails(commentDetails);
	 * responseStatus.setResponseStatus("Success"); return responseStatus; }
	 */

	@RequestMapping(value = "/savecomment", method = RequestMethod.POST)
	public @ResponseBody CommentDetails saveComment(HttpServletRequest request,
			@RequestBody CommentDetails commentDetails) {
		logger.info("Start saveComment");
		ResponseStatus responseStatus = new ResponseStatus();
		commentDetails.setTimestamp(new Date());
		Long userId = (long) Long.parseLong(request.getSession().getAttribute("userId") + "".trim());
		commentDetails.setCommentedById(userId);
		commentDAO.saveCommentDetails(commentDetails);
		responseStatus.setResponseStatus("Success");
		return commentDetails;
	}

	@RequestMapping(value = "/savesharedetail", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus saveSharedetail(HttpServletRequest request,
			@RequestBody ShareDetails shareDetails) {
		logger.info("Start saveSharedetails");
		ResponseStatus responseStatus = new ResponseStatus();
		Long userId = Long.parseLong((request.getSession().getAttribute("userId") + "").trim());
		shareDetails.setSharedById(userId);
		shareDAO.saveShareDetails(shareDetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}

	@RequestMapping(value = "/likeandunlike", method = RequestMethod.POST)
	public @ResponseBody Boolean saveLikeAndUnlike(HttpServletRequest request, @RequestBody PostDetails postDetails) {
		logger.info("Start saveLikeAndUnlike");
		postDetails.setLikedById((String) request.getSession().getAttribute("userId"));
		Boolean status = postDAO.saveLikeAndUnlike(postDetails);
		return status;
	}

	@RequestMapping(value = "/getUserListsByName", method = RequestMethod.GET)
	public @ResponseBody List<UserDetails> getUsersbyName(HttpServletRequest request,
			@RequestParam("searchText") String searchText) {
		logger.info("Start Users List");
		ResponseStatus responseStatus = new ResponseStatus();
		List<UserDetails> userList = userDAO.getUsersByName(searchText);
		responseStatus.setResponseStatus("Success");
		return userList;
	}

	@RequestMapping(value = "/getfriends", method = RequestMethod.GET)
	public @ResponseBody List<Map> getFriendsListDetailsByUserID(HttpServletRequest request) throws Exception {
		logger.info("Start getFriendsListDetailsByUserID");
		List<Map> userFriendsDetails = null;
		try {
			String id = (String) request.getSession(false).getAttribute("userId");
			id = id.trim();
			Long userId = Long.parseLong(id);
			userFriendsDetails = userDAO.getFriendsListDetailsByUserID(userId);

		} catch (NumberFormatException | SQLException | NullPointerException | ArrayIndexOutOfBoundsException e) {
			logger.error("Exception occured at getFriendsListDetailsByUserID");
			throw new Exception(e);
			
		}
		return userFriendsDetails;
	}

}
