package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeuz.cricbounz.model.WicketTypes;



@Repository
public class WicketDAO extends BaseDAO<WicketTypes, Integer> {
	
	@Autowired
	public WicketDAO(SessionFactory sessionFactory) {
		super(WicketTypes.class);
		super.setSessionFactory(sessionFactory);
	}

	public void wicketDetails(WicketTypes wicketTypes) {
		saveorUpdate(wicketTypes);
	}

}
