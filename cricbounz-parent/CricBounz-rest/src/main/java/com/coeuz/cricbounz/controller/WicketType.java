package com.coeuz.cricbounz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.coeuz.cricbounz.dao.WicketDAO;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.model.WicketTypes;


@Controller
@RequestMapping(value = "/rest/wickettypes")
public class WicketType {
	
private static final Logger logger = LoggerFactory.getLogger(WicketType.class);
	
	@Autowired
	private WicketDAO wicketDAO;
		
	@RequestMapping(value = "/wickettype", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus wicketType(@RequestBody WicketTypes wicketTypes) {
		logger.info("Start wicketType method");
		ResponseStatus responseStatus = new ResponseStatus();		
		wicketDAO.wicketDetails(wicketTypes);
		responseStatus.setResponseStatus("sucess");
		return responseStatus;
	}

}

