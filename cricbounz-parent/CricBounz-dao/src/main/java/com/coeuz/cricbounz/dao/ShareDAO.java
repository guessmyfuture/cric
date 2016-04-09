package com.coeuz.cricbounz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.coeuz.cricbounz.model.ShareDetails;
@Repository
public class ShareDAO  extends BaseDAO <ShareDetails, Integer> {

	private Session session;
	private SessionFactory sessionFactory;
	
	@Autowired
    public ShareDAO(SessionFactory sessionFactory) {
        super(ShareDetails.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void saveShareDetails(ShareDetails shareDetails){
		saveorUpdate(shareDetails);
	}

}
