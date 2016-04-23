package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.FriendRequest;


@Repository
public class FriendRequestDAO extends BaseDAO<FriendRequest, Integer>{

		
		@Autowired
		public FriendRequestDAO(SessionFactory sessionFactory) {
		super(FriendRequest.class);
		super.setSessionFactory(sessionFactory);

	}

	public void createfriendRequest(FriendRequest friendrequest) {
		saveorUpdate(friendrequest);
		
	}
	public FriendRequest getFriendRequestidDetails(long fiendReqId) {
		FriendRequest friendrequest = null;
		friendrequest = (FriendRequest) get(fiendReqId);
		return friendrequest;
	}
	

}
