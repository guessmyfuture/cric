package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.CommentDetails;

@Repository
public class CommentDAO extends BaseDAO <CommentDetails, Integer> {
	@Autowired
    public CommentDAO(SessionFactory sessionFactory) {
        super(CommentDetails.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void registerCommentDetails(CommentDetails commentDetails){
		saveorUpdate(commentDetails);
	}


}
