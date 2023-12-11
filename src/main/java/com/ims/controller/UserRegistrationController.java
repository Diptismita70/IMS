package com.ims.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ims.bean.UserRegistrationinfo;
import com.ims.entity.UserRegistration;
import com.ims.repository.UserRegistrationRepository;
import com.ims.service.UserRegistrationService;

@RestController
@RequestMapping("/api/v1/user")

public class UserRegistrationController {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	UserRegistrationRepository userRegistrationRepo;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	UserRegistration register(@RequestBody UserRegistrationinfo userRegistrationinfo) {
		return userRegistrationService.register(userRegistrationinfo);
	}
	 @PutMapping("/edit/{id}")
	 Optional<Object> update(@RequestBody UserRegistration newUser, @PathVariable Long id) {
	        return userRegistrationRepo.findById(id)
	                .map(user -> {
	                    user.setUserName(newUser.getUserName());
	                    user.setPassword(newUser.getPassword());
	                    user.setFirstName(newUser.getFirstName());
	                    user.setMiddileName(newUser.getMiddileName());
	                    user.setLastName(newUser.getLastName());
	                    user.setEmailId(newUser.getEmailId());	                    
	                    return userRegistrationRepo.save(user);
	                });
	    }
					
    @GetMapping("/getAll/")
    
    public List<UserRegistration> getAll(){
    	return userRegistrationRepo.findAll();
    }
    
    @GetMapping("/getAll/{id}")
    Optional<UserRegistration> getUserById(@PathVariable Long id) {
    	return userRegistrationService.getById(id);
    			
    }
    @DeleteMapping("/deleteAll/{id}")
    String deleteUser(@PathVariable Long id) {
    	if(userRegistrationRepo.existsById(id)) {
    		
    	}
    	userRegistrationRepo.deleteById(id);
    	return "User with id"+id+"has been deleted success.";
    }
    
}
