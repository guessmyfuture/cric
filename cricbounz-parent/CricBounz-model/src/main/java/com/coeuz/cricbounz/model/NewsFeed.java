package com.coeuz.cricbounz.model;

import org.springframework.stereotype.Component;

@Component
public class NewsFeed {
	private String postedby;
	private String postContentMessage;
	private String postCaption;
	private String mediaType;
	private String contentUrl;
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public String getPostContentMessage() {
		return postContentMessage;
	}
	public void setPostContentMessage(String postContentMessage) {
		this.postContentMessage = postContentMessage;
	}
	public String getPostCaption() {
		return postCaption;
	}
	public void setPostCaption(String postCaption) {
		this.postCaption = postCaption;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	

}
