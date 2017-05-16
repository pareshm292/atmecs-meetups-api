package com.atmecs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atmecs.model.MeetUp;

public interface MeetUpRepository extends CrudRepository<MeetUp, String> {

	public List<MeetUp> getMeetUpByPresenter(String name);
	
	//public List<MeetUp> getMeetUpByChiefGuest(String chiefguest);
	
}
