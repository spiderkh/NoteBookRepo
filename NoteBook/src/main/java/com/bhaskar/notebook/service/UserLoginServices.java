package com.bhaskar.notebook.service;

import org.springframework.stereotype.Service;

import com.bhaskar.notebook.dto.UserLoginDbDTO;
import com.bhaskar.notebook.dto.UserRegistrationDTO;


public interface UserLoginServices {
	
	public UserLoginDbDTO saveUserLogin(UserLoginDbDTO userLoginDbDTO);
	public long countOfUser();

}
