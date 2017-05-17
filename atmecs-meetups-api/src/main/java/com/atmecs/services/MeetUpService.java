package com.atmecs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.model.Guest;
import com.atmecs.model.MeetUp;
import com.atmecs.repository.MeetUpRepository;

@Service
public class MeetUpService {

	@Autowired
	private MeetUpRepository meetUpRepository;
	
	public List<MeetUp> getAllMeetUps(){
		
		List<MeetUp> meetUps = new ArrayList<>();
		for (MeetUp meetUp : meetUpRepository.findAll()) {
			meetUps.add(meetUp);
		}
		
		return meetUps;
	}

	public void addMeetUp(MeetUp meetUp) {
		
		System.out.println("in add meetup");
		meetUpRepository.save(meetUp);
	}

	public void removeMeetUp(String title) {
		meetUpRepository.delete(title);		
	}

	public void updateMeetUp(MeetUp meetup) {
		
		List<Guest> templist = new ArrayList<>();
		
		System.out.println("names of ");
		for (Guest guest : meetup.getListOfGuests()) {
			System.out.println(guest.getName());
		}
		//MeetUp meet = meetUpRepository.findOne(meetup.getTitle());
		templist = meetUpRepository.findOne(meetup.getTitle()).getListOfGuests();
		for (Guest guest : templist) {
			System.out.println(guest);
		}
		meetup.setListOfGuests(templist);
		meetUpRepository.save(meetup);
	}
	
	public List<MeetUp> getMeetUpsByPresenter(String name){
		List<MeetUp> meetups = new ArrayList<>();
		for (MeetUp meetUp : meetUpRepository.getMeetUpByPresenter(name)) {
			meetups.add(meetUp);
		}
		return meetups;
		
		
	}

	public MeetUp getMeetUp(String title) {
		return meetUpRepository.findOne(title);
	}

	
	public void addGuestToMeetUp(Guest guest,String title){
	
		MeetUp meetUp = meetUpRepository.findOne(title);
		meetUp.getListOfGuests().add(guest);
		meetUpRepository.save(meetUp);
	
	}
}
