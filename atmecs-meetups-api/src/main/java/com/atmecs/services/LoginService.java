package com.atmecs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.model.Guest;
import com.atmecs.repository.LoginRepository;


@Service
public class LoginService {

	
	@Autowired
	private LoginRepository loginRepository;
	
	
	public Guest validateGuest(String email,String password){
		return loginRepository.getGuestByEmailAndPassword(email, password);
	}
	
	
	
}
