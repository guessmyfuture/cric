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
@Table(name = "sharedetails")
@Component
public class ShareDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="shareId")
	private long shareId;
	private long postId;
	private long sharedById;
    private String sharedType;
    private String sharedConetnt;
    private Date  timestamp;
    private String status;
    @Transient
    private String sharedUserImage;
    	
	public long getShareId() {
		return shareId;
	}
	public void setShareId(long shareId) {
		this.shareId = shareId;
	}
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public long getSharedById() {
		return sharedById;
	}
	public void setSharedById(long sharedById) {
		this.sharedById = sharedById;
	}
	public String getSharedType() {
		return sharedType;
	}
	public void setSharedType(String sharedType) {
		this.sharedType = sharedType;
	}
	public String getSharedConetnt() {
		return sharedConetnt;
	}
	public void setSharedConetnt(String sharedConetnt) {
		this.sharedConetnt = sharedConetnt;
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
	public String getSharedUserImage() {
		return sharedUserImage;
	}
	public void setSharedUserImage(String sharedUserImage) {
		this.sharedUserImage = sharedUserImage;
	}
    
    
}
