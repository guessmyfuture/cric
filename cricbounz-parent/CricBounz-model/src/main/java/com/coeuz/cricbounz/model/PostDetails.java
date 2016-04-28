package com.coeuz.cricbounz.model;

import java.io.Serializable;
import java.util.ArrayList;
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
public class PostDetails implements Serializable {
	
	private static final long serialVersionUID = 1274119084524542751L;
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
    @Transient
    private String[] postedPictures;
    private String imagePostUrl;
    public String getImagePostUrl() {
		return imagePostUrl;
	}
	public void setImagePostUrl(String imagePostUrl) {
		this.imagePostUrl = imagePostUrl;
	}

	private String likedById;
    private String postedType;
	private String imageCaption;
	private String status;
	@Transient
	private String likedStatus;
	@Transient
	private List<UtilUserDetails> likedUserDetails=new ArrayList<UtilUserDetails>();
		
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
	
	public List<UtilUserDetails> getLikedUserDetails() {
		return likedUserDetails;
	}
	public void setLikedUserDetails(List<UtilUserDetails> likedUserDetails) {
		this.likedUserDetails = likedUserDetails;
	}
		
	@OneToMany
    @JoinColumn(name="postId")
    private List<CommentDetails> commentDetailsList=new ArrayList<CommentDetails>();
		
	/**
	 * @return the commentDetailsList
	 */
	public List<CommentDetails> getCommentDetailsList() {
		return commentDetailsList;
	}
	/**
	 * @param commentDetailsList the commentDetailsList to set
	 */
	public void setCommentDetailsList(List<CommentDetails> commentDetailsList) {
		this.commentDetailsList = commentDetailsList;
	}
	
	@OneToMany
    @JoinColumn(name="postId")
	private List<ShareDetails> shareDetailsList=new ArrayList<ShareDetails>();;
	
	/**
	 * @return the shareDetailsList
	 */
	public List<ShareDetails> getShareDetailsList() {
		return shareDetailsList;
	}
	/**
	 * @param shareDetailsList the shareDetailsList to set
	 */
	public void setShareDetailsList(List<ShareDetails> shareDetailsList) {
		this.shareDetailsList = shareDetailsList;
	}
	

	
}
