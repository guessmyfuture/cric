package com.coeuz.cricbounz.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "postdetails")
@Component
public class PostDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="postId")
	private long postId;
	private long postedUserId;
	@Transient
    private String postedUserName;
    private String postedUserImageUrl;
    private String postedContent;
    private Date  timestamp;
    private String[] postedPictures;
    private String likedById;
    private String postedType;
	private String imageCaption;
	private String status;
	@Transient
	private String likedStatus;
	@Transient
	private List<String> likedUserDetails;
		
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public long getPostedUserId() {
		return postedUserId;
	}
	public void setPostedUserId(long postedUserId) {
		this.postedUserId = postedUserId;
	}
	public String getPostedUserName() {
		return postedUserName;
	}
	public void setPostedUserName(String postedUserName) {
		this.postedUserName = postedUserName;
	}
	public String getPostedUserImageUrl() {
		return postedUserImageUrl;
	}
	public void setPostedUserImageUrl(String postedUserImageUrl) {
		this.postedUserImageUrl = postedUserImageUrl;
	}
		
	public String getPostedContent() {
		return postedContent;
	}
	public void setPostedContent(String postedContent) {
		this.postedContent = postedContent;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String[] getPostedPictures() {
		return postedPictures;
	}
	public void setPostedPictures(String[] postedPictures) {
		this.postedPictures = postedPictures;
	}
	
	public String getPostedType() {
		return postedType;
	}
	public void setPostedType(String postedType) {
		this.postedType = postedType;
	}
	public String getImageCaption() {
		return imageCaption;
	}
	public void setImageCaption(String imageCaption) {
		this.imageCaption = imageCaption;
	}
	
	public String getLikedById() {
		return likedById;
	}
	public void setLikedById(String likedById) {
		this.likedById = likedById;
	}
	
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getLikedStatus() {
		return likedStatus;
	}
	public void setLikedStatus(String likedStatus) {
		this.likedStatus = likedStatus;
	}
	
	public List<String> getLikedUserDetails() {
		return likedUserDetails;
	}
	public void setLikedUserDetails(List<String> likedUserDetails) {
		this.likedUserDetails = likedUserDetails;
	}
		
	@OneToMany
    @JoinColumn(name="postId")
    private Set<CommentDetails> commentDetailsList;
		
	public Set<CommentDetails> getCommentDetailsList() {
		return commentDetailsList;
	}
	public void setCommentDetailsList(Set<CommentDetails> commentDetailsList) {
		this.commentDetailsList = commentDetailsList;
	}
	
	@OneToMany
    @JoinColumn(name="postId")
	private Set<ShareDetails> shareDetails;

	public Set<ShareDetails> getShareDetails() {
		return shareDetails;
	}
	public void setShareDetails(Set<ShareDetails> shareDetails) {
		this.shareDetails = shareDetails;
	}

}
