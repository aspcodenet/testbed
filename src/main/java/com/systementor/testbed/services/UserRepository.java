package com.systementor.testbed.services;

import org.springframework.data.repository.CrudRepository;

import com.systementor.testbed.services.model.UserAccount;

public interface UserRepository extends CrudRepository<UserAccount, Integer> { 
    public UserAccount findByEmail(String email);
}