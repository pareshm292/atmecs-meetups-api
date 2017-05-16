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

	
	@RequestMapping(value="/meetups")
	public List<MeetUp> getAllMeetUps(){
		
		return meetUpService.getAllMeetUps();
	}
	
	@RequestMapping(value="/meetups/{title}")
	public MeetUp getMeetUp(@PathVariable String title){
		
		return meetUpService.getMeetUp(title);
	}
	
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
	
	@RequestMapping(value="/meetupsbypresenter={name}",method=RequestMethod.GET)
	public List<MeetUp> getMeetUpsByPresenter(@PathVariable String name){
		
		System.out.println(name);
		return meetUpService.getMeetUpsByPresenter(name);
	}
	
	
	
	
	
}
