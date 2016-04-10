package com.coeuz.cricbounz.dao;


import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.coeuz.cricbounz.model.UserDetails;
import com.coeuz.cricbounz.model.UserRegistration;
@Component
public class UserRegistrationDAO  {

	@Autowired
	UserDAO userDAO;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource hiberDataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(hiberDataSource);
	}
			
	public void registerUser(UserRegistration reg, UserDetails useDtl){
	
		userDAO.save(useDtl);
		String query = "INSERT INTO USERS (username, password, enabled) VALUES(?,?,?)";
		jdbcTemplate.update(query, new Object[]{
			reg.getUsername(), reg.getPassword(), reg.getEnabled()
		});
		String authorityQuery = "INSERT INTO authorities (username, authority) VALUES(?,?)";
		jdbcTemplate.update(authorityQuery, new Object[]{
				reg.getUsername(), "ROLE_USER"
			});
	}
	

}
