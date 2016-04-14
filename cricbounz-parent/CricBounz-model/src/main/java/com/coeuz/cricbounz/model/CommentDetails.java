package com.coeuz.cricbounz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Entity
@Table(name = "commentdetails")
@Component
public class CommentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="commentId")
	private long commentId;
	private long postId;
	private long commentedById;
	private String content;
	private Date  timestamp;
	private String status;
	@Transient
	private String commentedByImage;
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	
	public long getCommentedById() {
		return commentedById;
	}
	public void setCommentedById(long commentedById) {
		this.commentedById = commentedById;
	}
	
	public String getCommentedByImage() {
		return commentedByImage;
	}
	public void setCommentedByImage(String commentedByImage) {
		this.commentedByImage = commentedByImage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
		
}
