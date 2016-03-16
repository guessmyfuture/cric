package com.coeuz.cricbounz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeuz.cricbounz.model.NewsFeedList;
import com.coeuz.cricbounz.dao.FeedListDAO;

@Controller
@RequestMapping(value = "/user/newsfeed")
public class RestNewsFeedService {
	
	@Autowired
	private NewsFeedList feedList;
	
	@Autowired
	private FeedListDAO feedDAO;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public@ResponseBody NewsFeedList getNewsFeed()
	{
		List list = feedDAO.getNewsFeed();
		feedList.setNewsFeedList(list);
		return feedList;
	}

}
