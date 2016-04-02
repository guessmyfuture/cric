package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "postdetails")
@Component
public class PostDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	private String postType;
	private String postComment;
	private Date  timestamp;
	private String caption;
	private String likeuserid;
	private String comments;
	private String postsource;
	private String postedbyuid;
	private String postedto;
	private String postedstatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getPostComment() {
		return postComment;
	}
	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getLikeuserid() {
		return likeuserid;
	}
	public void setLikeuserid(String likeuserid) {
		this.likeuserid = likeuserid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPostsource() {
		return postsource;
	}
	public void setPostsource(String postsource) {
		this.postsource = postsource;
	}
	public String getPostedbyuid() {
		return postedbyuid;
	}
	public void setPostedbyuid(String postedbyuid) {
		this.postedbyuid = postedbyuid;
	}
	public String getPostedto() {
		return postedto;
	}
	public void setPostedto(String postedto) {
		this.postedto = postedto;
	}
	public String getPostedstatus() {
		return postedstatus;
	}
	public void setPostedstatus(String postedstatus) {
		this.postedstatus = postedstatus;
	}
	
	

}
