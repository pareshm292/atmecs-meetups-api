package com.atmecs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.model.MeetUp;
import com.atmecs.services.MeetUpService;

@RestController
@RequestMapping("/webapi")
public class MeetUpController {

	@Autowired
	private MeetUpService meetUpService;


	//private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		
	
	
}
