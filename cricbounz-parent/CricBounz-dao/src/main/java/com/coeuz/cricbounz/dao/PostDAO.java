package com.coeuz.cricbounz.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.CommentDetails;
import com.coeuz.cricbounz.model.PostDetails;
import com.coeuz.cricbounz.model.ShareDetails;
import com.coeuz.cricbounz.model.UserDetails;
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
		if(postDetails.getPostId()==0){
			saveorUpdate(postDetails);	
		}else if(postDetails.getPostId()!=0 && postDetails.getStatus().equals("D")){
			CommentDetails commentDetails = new CommentDetails();
			commentDetails.setPostId(postDetails.getPostId());
			commentDetails.setStatus(postDetails.getStatus());
			commentDAO.saveorUpdate(commentDetails);
			ShareDetails shareDetails = new ShareDetails();
			shareDetails.setPostId(postDetails.getPostId());
			shareDetails.setStatus(postDetails.getStatus());
			shareDAO.saveorUpdate(shareDetails);
		}
					
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
	
	public List<PostDetails> getPostDetails(long userId ){
		List<PostDetails> postDetailsList= new ArrayList<PostDetails>();
		session = getSessionFactory().openSession();
		session.beginTransaction();
		
		String publicShareHql="FROM PostDetails p WHERE p.postedUserId="+userId+" and p.postedType ='Public' and p.status='A' order by p.timestamp desc";
		Query publicShareQuery = session.createQuery(publicShareHql);
		List<PostDetails> retrievedPostedToPublicList =(List<PostDetails>)publicShareQuery.list();
		if(retrievedPostedToPublicList!=null && retrievedPostedToPublicList.size()>0){
			List<PostDetails> publicPostDetailsList = populateUserNameAndLikeDetails(retrievedPostedToPublicList);
			postDetailsList.addAll(publicPostDetailsList);	
		}
		String privateShareHql="FROM PostDetails p WHERE p.postedUserId="+userId+" and p.postedType ='Private' and p.status='A' order by p.timestamp desc";
		Query privateShareQuery = session.createQuery(privateShareHql);
		List<PostDetails> retrievedPostedToPrivateList =(List<PostDetails>)privateShareQuery.list();
		if(retrievedPostedToPrivateList!=null && retrievedPostedToPrivateList.size()>0){
			List<PostDetails> priavtePostDetailsList = populateUserNameAndLikeDetails(retrievedPostedToPrivateList);
			postDetailsList.addAll(priavtePostDetailsList);	
		}
		String friendsShareHql="FROM PostDetails p WHERE p.postedUserId="+userId+" and p.postedType like '%"+userId+",%' and p.status='A' order by p.timestamp desc";
		Query friendsShareQuery = session.createQuery(friendsShareHql);
		List<PostDetails> retrievedPostedToFriendsList =(List<PostDetails>)friendsShareQuery.list();
		if(retrievedPostedToFriendsList!=null && retrievedPostedToFriendsList.size()>0){
			List<PostDetails> friedndsPostDetailsList = populateUserNameAndLikeDetails(retrievedPostedToFriendsList);
			postDetailsList.addAll(friedndsPostDetailsList);	
		}
			
		return postDetailsList;
	}
			
	private List<PostDetails> populateUserNameAndLikeDetails(List<PostDetails> postList){
		session = getSessionFactory().openSession();
		session.beginTransaction();
		List<PostDetails> usreNameAndLikedNamePopulatedList= new ArrayList<PostDetails>();
		String delimit=",";
		String likedUserDetails;
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
				StringTokenizer likedUsersIds = new StringTokenizer(postDetails.getLikedById(),delimit);
				List<String> likedUserDetailsList = new ArrayList<String>();
				while(likedUsersIds.hasMoreElements()){
					long likeduserId =Long.parseLong((String)likedUsersIds.nextElement());
					String likedUserHql="FROM UserDetails u WHERE u.userId="+likeduserId;
					Query likedUserQuery = session.createQuery(likedUserHql);
					List<UserDetails> likedUsersList =(List<UserDetails>)likedUserQuery.list();
					if(likedUsersList!=null && likedUsersList.size()>0){
						UserDetails userDetails = userDetailsList.get(0);
						likedUserDetails=userDetails.getName();
						likedUserDetails=likeduserId+":"+likedUserDetails;
						likedUserDetailsList.add(likedUserDetails);
						postDetails.setLikedUserDetails(likedUserDetailsList);
					}
				 }
				usreNameAndLikedNamePopulatedList.add(postDetails);
			}
		}
		
	    return usreNameAndLikedNamePopulatedList;	
	}
	
	
	public void likePost(PostDetails postDetails){
		List<PostDetails> likedPostDetails = null;
		String likedUserHql="FROM PostDetails p WHERE p.postId="+postDetails.getPostId();
		Query likedUserQuery = session.createQuery(likedUserHql);
		List<PostDetails> likedPostList =(List<PostDetails>)likedUserQuery.list();
		if(likedPostList !=null && likedPostList.size()>0){
			PostDetails retrievedPostDetails = likedPostList.get(0);
			String likedUserIds=retrievedPostDetails.getLikedById();
			likedUserIds=likedUserIds+","+postDetails.getLikedById();
			
		}	
			
		
		
	}
	
	
	
	
}
