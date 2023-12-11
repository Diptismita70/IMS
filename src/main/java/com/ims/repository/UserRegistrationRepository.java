package com.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ims.entity.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
	UserRegistration findByUserName(String UserName);

}
