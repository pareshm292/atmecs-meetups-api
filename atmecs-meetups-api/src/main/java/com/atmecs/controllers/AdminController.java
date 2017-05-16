package com.atmecs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.model.Guest;
import com.atmecs.services.GuestService;
import com.atmecs.services.LoginService;
import com.atmecs.services.MeetUpService;

@RestController
@RequestMapping(value="/webapi/admin")
public class AdminController {

	@Autowired
	private GuestService guestService;
	
	@Autowired 
	private MeetUpService meetUpService;
	
	
	
	
	
	
	
	
}
