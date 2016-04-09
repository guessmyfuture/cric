package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.PitchTypeDetails;

@Repository
public class PitchTypeDAO extends BaseDAO<PitchTypeDetails, Integer> {

	@Autowired
	public PitchTypeDAO(SessionFactory sessionFactory) {
		super(PitchTypeDetails.class);
		super.setSessionFactory(sessionFactory);
	}

	public void addPitchTypeDetails(PitchTypeDetails pitchTypeDetails) {
		saveorUpdate(pitchTypeDetails);
	}

	public PitchTypeDetails getPitchTypeDetails(long pitchId) {
		PitchTypeDetails pitchType = null;
		pitchType = (PitchTypeDetails) get(pitchId);
		return pitchType;
	}

}
