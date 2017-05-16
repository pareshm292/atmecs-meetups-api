package com.atmecs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atmecs.model.Guest;


public interface GuestRepository extends CrudRepository<Guest, Integer> {

	
	public Guest findGuestByEmail(String email);
}
