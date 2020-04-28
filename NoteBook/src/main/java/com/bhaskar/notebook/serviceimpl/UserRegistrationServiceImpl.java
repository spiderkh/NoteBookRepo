package com.bhaskar.notebook.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bhaskar.notebook.dto.UserRegistrationDTO;
import com.bhaskar.notebook.repo.UserRegistrationRepo;
import com.bhaskar.notebook.service.UserRegistrationService;

@Component("UserRegistrationServiceImpl")
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	UserRegistrationRepo userRegistrationRepo;

	@Override
	public UserRegistrationDTO userRegistration(UserRegistrationDTO userRegistrationDTO) {
		// TODO Auto-generated method stub
		
		
		return userRegistrationRepo.save(userRegistrationDTO);
	}
	
	

}
