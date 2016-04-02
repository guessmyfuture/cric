package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.PostDetails;
@Repository
public class PostDAO extends BaseDAO <PostDetails, Integer> {
	
	@Autowired
    public PostDAO(SessionFactory sessionFactory) {
        super(PostDetails.class);
        super.setSessionFactory(sessionFactory);
    }

	public void registerPostDetails(PostDetails postDetails){
		saveorUpdate(postDetails);
	}
	
	
	
}
