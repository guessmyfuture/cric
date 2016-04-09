package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.BallTypeDetails;
import com.coeuz.cricbounz.model.PostDetails;
@Repository
public class BallTypeDAO extends BaseDAO <BallTypeDetails, Integer> {

	@Autowired
    public BallTypeDAO(SessionFactory sessionFactory) {
        super(BallTypeDetails.class);
        super.setSessionFactory(sessionFactory);
    }
	
	public void addBallTypeDetails(BallTypeDetails ballType){
		saveorUpdate(ballType);
	}
	
	public BallTypeDetails getBallTypeDetails(long ballTypeId){
		BallTypeDetails ballType = null;
		ballType =(BallTypeDetails)get(ballTypeId);
		return ballType;
	}
}
