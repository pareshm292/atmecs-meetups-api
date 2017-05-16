package com.atmecs.repository;

import org.springframework.data.repository.CrudRepository;

import com.atmecs.model.Guest;

public interface LoginRepository extends CrudRepository<Guest, Integer> {

	
	public Guest getGuestByEmailAndPassword(String name,String password);
	
	
}
