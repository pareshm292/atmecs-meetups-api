package com.atmecs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.model.Guest;
import com.atmecs.model.MeetUp;
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
	
	
	

	@RequestMapping(value="/meetups",method=RequestMethod.POST)
	public void addMeetUp(@RequestBody MeetUp meetUp){
		
		 meetUpService.addMeetUp(meetUp);
		
	}

	

	@RequestMapping(value="/meetups/{title}",method=RequestMethod.DELETE)
	public void removeMeetup(@PathVariable String title){
	
		meetUpService.removeMeetUp(title);
		
	}
	
	@RequestMapping(value="/meetups/{title}",method=RequestMethod.PUT)
	public void updateMeetup(@PathVariable String title,@RequestBody MeetUp meetup){
	
		meetUpService.updateMeetUp(meetup);
		
	}
	
	@RequestMapping(value="/guests",method=RequestMethod.GET)
	public List<Guest> getAllRegisteredGuests(){
		
		return guestService.getAllRegisteredGuests();
	}
	

	@RequestMapping(value="/guests/{id}",method=RequestMethod.DELETE)
	public void removeGuest(@PathVariable Integer id){
		guestService.removeGuest(id);
	}	
	
	
	
	
	
	
}
