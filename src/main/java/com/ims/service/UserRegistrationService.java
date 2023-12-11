package com.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.bean.UserRegistrationinfo;
import com.ims.entity.UserRegistration;
import com.ims.repository.UserRegistrationRepository;

@Service

public class UserRegistrationService {
	
	@Autowired
	UserRegistrationRepository UserRegistrationRepository;
	
	public UserRegistration register(UserRegistrationinfo userregistrationinfo) {
		return UserRegistrationRepository.save(userregistrationinfo.convertedToEntity());
	}
    public UserRegistration update(UserRegistration userregistration) {
    	return UserRegistrationRepository.save(userregistration);
    }
    public String checkRegistraion(String newuserName) {
    	UserRegistration existingUser = UserRegistrationRepository.findByUserName(newuserName);
    	
    	if (existingUser != null) {
    		return "UserName already registered!";
    	}
    	else {
    		return "Registration Successful!";
    	}
    }
    
    public List<UserRegistration> getAll(){
    	return UserRegistrationRepository.findAll();
    }
    public Optional<UserRegistration> getById(Long id){
    	return UserRegistrationRepository.findById(id);
    }
}
