package com.coeuz.cricbounz.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NewsFeedList {
	
	private List<NewsFeed> newsFeedList;

	public List<NewsFeed> getNewsFeedList() {
		return newsFeedList;
	}

	public void setNewsFeedList(List<NewsFeed> newsFeedList) {
		this.newsFeedList = newsFeedList;
	} 

}
