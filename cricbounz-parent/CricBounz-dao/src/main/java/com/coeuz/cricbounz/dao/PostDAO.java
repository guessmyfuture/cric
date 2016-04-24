package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.CommentDetails;
import com.coeuz.cricbounz.model.PostDetails;
import com.coeuz.cricbounz.model.ShareDetails;
import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UtilUserDetails;
@Repository
public class PostDAO extends BaseDAO <PostDetails, Integer> {
	private Session session;
	private SessionFactory sessionFactory;
	
	@Autowired
	CommentDAO commentDAO;
	
	@Autowired
	ShareDAO shareDAO;
	
	@Autowired
	UserDAO userDAO;
		
	@Autowired
    public PostDAO(SessionFactory sessionFactory) {
        super(PostDetails.class);
        super.setSessionFactory(sessionFactory);
    }

	public void savePostDetails(PostDetails postDetails){
		 saveorUpdate(postDetails);	
	}
	
	public void deletePostDetails(PostDetails postDetails){
		
		session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		String postHql="UPDATE PostDetails p SET p.status=:status WHERE p.postId=:postId";
		Query postQuery = session.createQuery(postHql);
		postQuery.setParameter("postId",postDetails.getPostId());
		postQuery.setParameter("status",postDetails.getStatus());
		postQuery.executeUpdate();
		
		String commentHql="UPDATE CommentDetails c SET c.status=:status WHERE c.postId=:postId";
		Query commentQuery = session.createQuery(commentHql);
		commentQuery.setParameter("postId",postDetails.getPostId());
		commentQuery.setParameter("status",postDetails.getStatus());
		commentQuery.executeUpdate();
		
		String sharedHql="UPDATE ShareDetails s SET s.status=:status WHERE s.postId=:postId";
		Query sharedQuery = session.createQuery(sharedHql);
		sharedQuery.setParameter("postId",postDetails.getPostId());
		sharedQuery.setParameter("status",postDetails.getStatus());
		sharedQuery.executeUpdate();
		
		session.flush();
		transaction.commit();
		session.close();
		
	}
	
	
		
	public List<PostDetails> getPostDetailsCriteria(long userId ){
		List<PostDetails> postDetailsList= new ArrayList<PostDetails>();
		session = getSessionFactory().openSession();
		session.beginTransaction();
		Criteria publicCriteria = session.createCriteria(PostDetails.class);
		publicCriteria.add(Restrictions.gt("postedUserId",userId));
		publicCriteria.add(Restrictions.gt("postedType", "Public"));
		publicCriteria.add(Restrictions.gt("status", "A"));
		publicCriteria.addOrder(Order.desc("timestamp"));
		List<PostDetails> postedToPublicList =(List<PostDetails>)publicCriteria.list();
		if(postedToPublicList!=null){
			postDetailsList.addAll(postedToPublicList);
		}
		Criteria privateCriteria = session.createCriteria(PostDetails.class);
		privateCriteria.add(Restrictions.gt("postedUserId",userId));
		privateCriteria.add(Restrictions.gt("postedType", "Private"));
		privateCriteria.add(Restrictions.gt("status", "A"));
		privateCriteria.addOrder(Order.desc("timestamp"));
		List<PostDetails> postedToPrivateList =(List<PostDetails>)privateCriteria.list();
		if(postedToPrivateList!=null){
			postDetailsList.addAll(postedToPrivateList);
		}
		Criteria friendsCriteria = session.createCriteria(PostDetails.class);
		friendsCriteria.add(Restrictions.gt("postedUserId",userId));
		friendsCriteria.add(Restrictions.ilike("postedType","%,"+ userId+",%"));
		friendsCriteria.add(Restrictions.gt("status", "A"));
		friendsCriteria.addOrder(Order.desc("timestamp"));
		List<PostDetails> PostedToFriendsList =(List<PostDetails>)friendsCriteria.list();
		if(PostedToFriendsList!=null){
			postDetailsList.addAll(PostedToFriendsList);
		}
		return postDetailsList;
	}
	
	public List<PostDetails> getPostDetails(long userId, int limit,int offset){
		List<PostDetails> postDetailsList= new ArrayList<PostDetails>();
		session = getSessionFactory().openSession();
		session.beginTransaction();
		
		String publicShareHql="FROM PostDetails p WHERE p.postedUserId="+userId+" and p.postedType ='Public' or p.postedType ='Private' or p.postedType like '%"+userId+",%' and p.status='A' order by p.timestamp desc";
		Query publicShareQuery = session.createQuery(publicShareHql);
		publicShareQuery.setFirstResult(offset);
		publicShareQuery.setMaxResults(limit);
		
		List<PostDetails> retrievedPostedToPublicList =(List<PostDetails>)publicShareQuery.list();
		if(retrievedPostedToPublicList!=null && retrievedPostedToPublicList.size()>0){
			List<PostDetails> publicPostDetailsList = populateUserNameAndImage(retrievedPostedToPublicList);
			postDetailsList.addAll(publicPostDetailsList);	
		}
		
		/*
		String privateShareHql="FROM PostDetails p WHERE p.postedUserId="+userId+" and p.postedType ='Private' and p.status='A' order by p.timestamp desc";
		Query privateShareQuery = session.createQuery(privateShareHql);
		List<PostDetails> retrievedPostedToPrivateList =(List<PostDetails>)privateShareQuery.list();
		if(retrievedPostedToPrivateList!=null && retrievedPostedToPrivateList.size()>0){
			List<PostDetails> priavtePostDetailsList = populateUserNameAndImage(retrievedPostedToPrivateList);
			postDetailsList.addAll(priavtePostDetailsList);	
		}
		String friendsShareHql="FROM PostDetails p WHERE p.postedUserId="+userId+" and p.postedType like '%"+userId+",%' and p.status='A' order by p.timestamp desc";
		Query friendsShareQuery = session.createQuery(friendsShareHql);
		List<PostDetails> retrievedPostedToFriendsList =(List<PostDetails>)friendsShareQuery.list();
		if(retrievedPostedToFriendsList!=null && retrievedPostedToFriendsList.size()>0){
			List<PostDetails> friedndsPostDetailsList = populateUserNameAndImage(retrievedPostedToFriendsList);
			postDetailsList.addAll(friedndsPostDetailsList);	
		}
			*/
		return postDetailsList;
	}
			
	private List<PostDetails> populateUserNameAndImage(List<PostDetails> postList){
		session = getSessionFactory().openSession();
		session.beginTransaction();
		List<PostDetails> usreNameAndLikedNamePopulatedList= new ArrayList<PostDetails>();
		List<CommentDetails> commentedUserImageAddedList = new ArrayList<CommentDetails>();
		List<ShareDetails> sharedUserImageAddedList= new ArrayList<ShareDetails>();
		String delimit=",";
		if(postList!=null && postList.size()>0){
			for(PostDetails postDetails:postList){
				String userHql="FROM UserDetails u WHERE u.userId="+postDetails.getPostedUserId();
				Query userQuery = session.createQuery(userHql);
				List<UserDetails> userDetailsList =(List<UserDetails>)userQuery.list();
				if(userDetailsList!=null && userDetailsList.size()>0){
					UserDetails userDetails = userDetailsList.get(0);
					postDetails.setPostedUserName(userDetails.getName());
					postDetails.setPostedUserImageUrl(userDetails.getProfileImageUrl());
				}
				
				if(postDetails.getCommentDetailsList()!=null&postDetails.getCommentDetailsList().size()>0){
					List<CommentDetails> commtedUserList =(List<CommentDetails>) postDetails.getCommentDetailsList();
					for(CommentDetails commentDetails: commtedUserList){
						String commtedUserHql="FROM UserDetails u WHERE u.userId="+commentDetails.getCommentedById();
						Query commentedUserQuery = session.createQuery(commtedUserHql);
						List<UserDetails> commentUserDetailsList =(List<UserDetails>)commentedUserQuery.list();
						if(commentUserDetailsList!=null&&commentUserDetailsList.size()>0){
							UserDetails commentedUserDetails =(UserDetails)commentUserDetailsList.get(0);
							commentDetails.setCommentedByImage(commentedUserDetails.getProfileImageUrl());
								
						}
					}
				}
				
				if(postDetails.getShareDetailsList()!=null&&postDetails.getShareDetailsList().size()>0){
					List<ShareDetails> sharedUserList =(List<ShareDetails>) postDetails.getShareDetailsList();
					for(ShareDetails shareDetails: sharedUserList){
						String sharedUserHql="FROM UserDetails u WHERE u.userId="+shareDetails.getSharedById();
						Query sharedUserQuery = session.createQuery(sharedUserHql);
						List<UserDetails> sharedUserDetailsList =(List<UserDetails>)sharedUserQuery.list();
						if(sharedUserDetailsList!=null&&sharedUserDetailsList.size()>0){
							UserDetails sharedUserDetails =(UserDetails)sharedUserDetailsList.get(0);
							shareDetails.setSharedUserImage(sharedUserDetails.getProfileImageUrl());
								
						}
					}
				}
				
				if(postDetails.getLikedById().length()>0){
					StringTokenizer likedUsersIds = new StringTokenizer(postDetails.getLikedById(),delimit);
					List<UtilUserDetails> likedUserDetailsList = new ArrayList<UtilUserDetails>();
					while(likedUsersIds.hasMoreElements()){
						long likeduserId =Long.parseLong((String)likedUsersIds.nextElement());
						String likedUserHql="FROM UserDetails u WHERE u.userId="+likeduserId;
						Query likedUserQuery = session.createQuery(likedUserHql);
						List<UserDetails> likedUsersList =(List<UserDetails>)likedUserQuery.list();
						if(likedUsersList!=null && likedUsersList.size()>0){
							UserDetails likedUserDetailsObj=null;
							UtilUserDetails likedUserDetails = new UtilUserDetails();
							likedUserDetailsObj = likedUsersList.get(0);
							likedUserDetails.setUserID(likeduserId);
							likedUserDetails.setUserName(likedUserDetailsObj.getName());
							likedUserDetails.setUserImage(likedUserDetailsObj.getProfileImageUrl());
							likedUserDetailsList.add(likedUserDetails);
							
													
						}
					 }
					postDetails.setLikedUserDetails(likedUserDetailsList);
				}

				usreNameAndLikedNamePopulatedList.add(postDetails);
			}
		}
		
	    return usreNameAndLikedNamePopulatedList;	
	}
	
			
	public boolean saveLikeAndUnlike(PostDetails postDetails){
		session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<PostDetails> updatedPostPostList = null;
		String delimit=",";
		String likedStatus="Like not updated";
		String existingPostHql="FROM PostDetails p WHERE p.postId="+postDetails.getPostId();
		Query existingPostQuery = session.createQuery(existingPostHql);
		List<PostDetails> existingPostList =(List<PostDetails>)existingPostQuery.list();
		
		boolean hasLikedbyUser = false;
		
		if(existingPostList !=null && existingPostList.size()>0){
			PostDetails existingPostDetails = existingPostList.get(0);
			
			/*
				if(postDetails.getLikedStatus().equals("L")){
				String existingLikedUserIds=existingPostDetails.getLikedById();
				if(existingLikedUserIds==null){
					existingLikedUserIds=postDetails.getLikedById()+",";	
				}else{
					existingLikedUserIds=existingLikedUserIds+postDetails.getLikedById()+",";	
				}
				
				String appendingLikedUserIdHql="UPDATE PostDetails p set p.likedById=:likedById where p.postId=:postId";
				Query appendingLikedUserIdQuery = session.createQuery(appendingLikedUserIdHql);
				appendingLikedUserIdQuery.setParameter("likedById",existingLikedUserIds);
				appendingLikedUserIdQuery.setParameter("postId",postDetails.getPostId());
				int updatStatus = appendingLikedUserIdQuery.executeUpdate();
				if(updatStatus==1){
					likedStatus="L";
			}
				session.flush();
				transaction.commit();
				session.close();
			}else{
			  */
			String reconstructedLikedIds=""; 
			boolean isUserIDExist = false;
			
			if(existingPostDetails.getLikedById().length()==0){
				reconstructedLikedIds=reconstructedLikedIds+postDetails.getLikedById()+",";
				hasLikedbyUser = true;
			}else if(existingPostDetails.getLikedById().length()>=1){
								
				if(existingPostDetails.getLikedById().contains(postDetails.getLikedById())){
					hasLikedbyUser = false;
					StringTokenizer existingLikedUsersIds = new StringTokenizer(existingPostDetails.getLikedById(),delimit);
					while(existingLikedUsersIds.hasMoreElements()){
						String existinglikedUserId=(String)existingLikedUsersIds.nextElement();
						if(!existinglikedUserId.equals(postDetails.getLikedById())){
							if(reconstructedLikedIds==null){
								reconstructedLikedIds= existinglikedUserId+",";	
							}
							else{
								reconstructedLikedIds=reconstructedLikedIds+existinglikedUserId+",";	
								
							}
						}
											
					}
					
					
				}else{
					
					reconstructedLikedIds = existingPostDetails.getLikedById()+postDetails.getLikedById()+",";
					hasLikedbyUser = true;
				}
					
			}
			
			String likedUserIdHql="UPDATE PostDetails p set p.likedById=:likedById where p.postId=:postId";
			Query likedUserIdQuery = session.createQuery(likedUserIdHql);
			likedUserIdQuery.setParameter("likedById",reconstructedLikedIds);
			likedUserIdQuery.setParameter("postId",postDetails.getPostId());
			int updateStatus = likedUserIdQuery.executeUpdate();
			
				session.flush();
				transaction.commit();
				session.close();
			}				
			
		return hasLikedbyUser;
	}	
	
}
