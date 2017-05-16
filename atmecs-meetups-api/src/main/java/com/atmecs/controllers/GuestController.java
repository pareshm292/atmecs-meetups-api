package com.atmecs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmecs.model.Guest;
import com.atmecs.services.GuestService;
import com.atmecs.services.MeetUpService;


@RestController
@RequestMapping(value="/webapi")
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private MeetUpService meetUpService;

	@RequestMapping(value="/guests",method=RequestMethod.GET)
	public List<Guest> getAllRegisteredGuests(){
		
		return guestService.getAllRegisteredGuests();
	}
	
	@RequestMapping(value="/guests",method=RequestMethod.POST)
	public void registerGuest(@RequestBody Guest guest){
		guestService.registerGuest(guest);
	}
	
	@RequestMapping(value="/guests/{id}",method=RequestMethod.DELETE)
	public void removeGuest(@PathVariable Integer id){
		guestService.removeGuest(id);
	}	
	
	@RequestMapping(value="/guests/{id}",method=RequestMethod.GET)
	public Guest getGuestById(@PathVariable Integer id){
		return guestService.getGuestById(id);
	}	
	

	@RequestMapping(value="/guests/{id}",method=RequestMethod.PUT)
	public void updateGuest(@PathVariable Integer id,@RequestBody Guest guest){
		
		//guest.setGuestId(id);
		guestService.updateGuest(id,guest);
	}	
	
	
}
