package com.bhaskar.notebook.service;

import org.springframework.stereotype.Service;

import com.bhaskar.notebook.dto.SignUpDTO;
import com.bhaskar.notebook.dto.UserRegistrationDTO;


public interface UserRegistrationService {
	
	public UserRegistrationDTO userRegistration(UserRegistrationDTO userRegistrationDTO);

}
