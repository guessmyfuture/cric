package com.coeuz.cricbounz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coeuz.cricbounz.model.ResponseStatus;
import com.coeuz.cricbounz.dao.RequestNotificationDAO;

@Controller
@RequestMapping(value = "/rest/notifications")
public class NotificationsController {
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationsController.class);
	
	@Autowired
	private RequestNotificationDAO requestNotificationDAO;
		
	@Autowired
	ResponseStatus responseStatus;

	
	/*@RequestMapping(value = "/addnotifications", method = RequestMethod.POST)
	public @ResponseBody ResponseStatus addNotificationsDetails(@RequestBody NotificationDetails notificationdetails) {
		logger.info("Starting addNotificationsDetails");
		ResponseStatus responseStatus = new ResponseStatus();
		notificationDAO.addNotificationDetails(notificationdetails);
		responseStatus.setResponseStatus("Success");
		return responseStatus;
	}
*/
}
