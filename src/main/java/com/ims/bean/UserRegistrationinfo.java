package com.ims.bean;

import com.ims.entity.UserRegistration;

import lombok.Data;

@Data

public class UserRegistrationinfo {
	 private String id;
     private String userName;
     private String password;
     private String firstName;
     private String middleName;
     private String lastName;
     private String emaild;
     
     public UserRegistration convertedToEntity() {
    	 
    	 UserRegistration user = new UserRegistration();
    	 if(id!=null && id!="0")
    	 user.setId(Long.valueOf(id)); 
         user.setUserName(userName);
    	 user.setPassword(password);
    	 user.setFirstName(firstName);
    	 user.setMiddileName(middleName);
    	 user.setLastName(lastName);
    	 user.setEmailId(emaild);
    	 return user;
     }
}
