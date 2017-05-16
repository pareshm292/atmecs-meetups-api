package com.atmecs.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.model.Guest;
import com.atmecs.repository.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
	private GuestRepository guestRepository;
	
	
	public List<Guest> getAllRegisteredGuests(){
		
		List<Guest> guests = new ArrayList<>();
		
		for (Guest guest : guestRepository.findAll()) {
			guests.add(guest);
		}
		return guests;
		
	}
	
	
	public Guest getGuestById(Integer id){
		
		return guestRepository.findOne(id);
	}
	
	public void registerGuest(Guest guest){
		
		guestRepository.save(guest);
		
	}

	public void removeGuest(Integer id){
		
		guestRepository.delete(id);
	}


	public void updateGuest(Integer id,Guest guest) {

		guest.setGuestId(id);
		guestRepository.save(guest);
		
	}
	
}
