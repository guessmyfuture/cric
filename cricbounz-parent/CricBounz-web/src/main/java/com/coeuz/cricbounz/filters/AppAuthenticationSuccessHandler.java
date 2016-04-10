package com.coeuz.cricbounz.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.coeuz.cricbounz.dao.UserDAO;

public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		HttpSession session = request.getSession();
		
		/*Set some session variables*/
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        //session.setAttribute("uname", authUser.getUsername());
        session.setAttribute("userId",  userDAO.getUserIdFromMail(authUser.getUsername()));
        session.setAttribute("authorities", authentication.getAuthorities()); 
	}
}
