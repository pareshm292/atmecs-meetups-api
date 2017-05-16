package com.atmecs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value="/webapi")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private MeetUpService meetUpService;


	
/*
 * 		To Register a new guest.
 */
	
	@RequestMapping(value="/guests",method=RequestMethod.POST)
	public ResponseEntity<Guest> registerGuest(@RequestBody Guest guest){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		guestService.registerGuest(guest);
		return new ResponseEntity<Guest>(headers,HttpStatus.OK);
	}
	
	@RequestMapping(value="/guests/{id}",method=RequestMethod.GET)
	public ResponseEntity<Guest> getGuestById(@PathVariable Integer id){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(guestService.getGuestById(id),headers,HttpStatus.OK);
	}	
	

	@RequestMapping(value="/guests/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Guest> updateGuest(@PathVariable Integer id,@RequestBody Guest guest){
		
		//guest.setGuestId(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<Guest>(guestService.getGuestById(id),headers,HttpStatus.OK);
	
	}	
	

	@RequestMapping(value="/meetups")
	public ResponseEntity<List<MeetUp>> getAllMeetUps(){
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(meetUpService.getAllMeetUps(),headers,HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/meetups/{title}")
	public ResponseEntity<MeetUp> getMeetUp(@PathVariable String title){
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(meetUpService.getMeetUp(title),headers,HttpStatus.OK);
	}
	
	
	
	
	
	@RequestMapping(value="/meetupsbypresenter={name}",method=RequestMethod.GET)
	public ResponseEntity<List<MeetUp>> getMeetUpsByPresenter(@PathVariable String name){
		
		//System.out.println(name);
		
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(meetUpService.getMeetUpsByPresenter(name),headers,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/meetups/{title}/guests/",method=RequestMethod.POST)
	public ResponseEntity<Guest> addGuestToMeetUp(@RequestBody Guest guest,@PathVariable String title){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		meetUpService.addGuestToMeetUp(guest, meetUpService.getMeetUp(title));
		return new ResponseEntity<Guest>(headers,HttpStatus.OK);
	}
	
	
}
