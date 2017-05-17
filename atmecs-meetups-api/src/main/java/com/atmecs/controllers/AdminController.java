package com.atmecs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.model.Guest;
import com.atmecs.model.MeetUp;
import com.atmecs.services.GuestService;
import com.atmecs.services.MeetUpService;

@RestController
@RequestMapping(value="/webapi/admin")
public class AdminController {

	@Autowired
	private GuestService guestService;
	
	@Autowired 
	private MeetUpService meetUpService;
	
	
	
	@CrossOrigin
	@RequestMapping(value="/meetups",method=RequestMethod.POST)
	public ResponseEntity<MeetUp> addMeetUp(@RequestBody MeetUp meetUp){
		
		meetUpService.addMeetUp(meetUp);
		 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<MeetUp> responseEntity = new ResponseEntity<MeetUp>(headers,HttpStatus.CREATED); 
		return responseEntity;
		 
		
	}

	
	@CrossOrigin
	@RequestMapping(value="/meetups/{title}",method=RequestMethod.DELETE)
	public ResponseEntity<MeetUp> removeMeetup(@PathVariable String title){
	
		meetUpService.removeMeetUp(title);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<MeetUp> responseEntity = new ResponseEntity<MeetUp>(headers,HttpStatus.OK);
		 
		return responseEntity;
	}
	
	@RequestMapping(value="/meetups/{title}",method=RequestMethod.PUT)
	public ResponseEntity<MeetUp> updateMeetup(@PathVariable String title,@RequestBody MeetUp meetup){
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		meetUpService.updateMeetUp(meetup);
		ResponseEntity<MeetUp> responseEntity = new ResponseEntity<MeetUp>(headers,HttpStatus.OK);
		 
		return responseEntity;

	}
	
	@RequestMapping(value="/guests",method=RequestMethod.GET)
	public ResponseEntity<List<Guest>> getAllRegisteredGuests(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<List<Guest>>(guestService.getAllRegisteredGuests(),headers,HttpStatus.OK);
	}
	

	@RequestMapping(value="/guests/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Guest> removeGuest(@PathVariable Integer id){
		guestService.removeGuest(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<Guest> responseEntity = new ResponseEntity<Guest>(headers,HttpStatus.OK); 
		return responseEntity;

	
	}	
	
}
