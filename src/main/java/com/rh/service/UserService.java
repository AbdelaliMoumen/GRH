package com.rh.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.rh.entity.User;
import com.rh.util.UserRegistrationDto;



public interface UserService extends UserDetailsService{
 User save(UserRegistrationDto registrationDto);
}