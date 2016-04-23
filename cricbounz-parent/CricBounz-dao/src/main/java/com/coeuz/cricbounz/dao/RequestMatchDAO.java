package com.coeuz.cricbounz.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.coeuz.cricbounz.model.RequestMatch;


@Repository
public class RequestMatchDAO extends BaseDAO<RequestMatch, Integer>{
	
	
	@Autowired
	public RequestMatchDAO(SessionFactory sessionFactory) {
		super(RequestMatch.class);
		super.setSessionFactory(sessionFactory);
	}

	
	public void RequestMatchDetails(RequestMatch requestmatch) {
		saveorUpdate(requestmatch);

		
	}
	public RequestMatch getRequestMatchidDetails(long Id) {
		RequestMatch requestmatch = null;
		requestmatch = (RequestMatch) get(Id);
		return requestmatch;
	}
	
}
