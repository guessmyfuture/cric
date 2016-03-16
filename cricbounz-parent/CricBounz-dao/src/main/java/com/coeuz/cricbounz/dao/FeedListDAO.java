package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coeuz.cricbounz.model.NewsFeed;
@Component
public class FeedListDAO {
	
	public List<NewsFeed> getNewsFeed()
	{
		List<NewsFeed> feedList = new ArrayList<NewsFeed>();
		for (int i=0;i<6;i++)
		{
			NewsFeed feed = new NewsFeed();
			feed.setPostedby(""+i);
			feed.setMediaType("TEXT");
			feed.setPostContentMessage("We are part of the Coeuz");
			feedList.add(feed);
		}
		return feedList;
	
	}

}
