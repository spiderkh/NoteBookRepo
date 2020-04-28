package com.bhaskar.notebook.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bhaskar.notebook.dto.UserLoginDbDTO;
import com.bhaskar.notebook.repo.UserLoginCrudRepo;
import com.bhaskar.notebook.service.UserLoginServices;

@Component("UserLoginServicesImpl")
@Service
public class UserLoginServicesImpl implements UserLoginServices {
	
	@Autowired
	UserLoginCrudRepo userLoginCrudRepo;

	@Override
	public UserLoginDbDTO saveUserLogin(UserLoginDbDTO userLoginDbDTO) {
		// TODO Auto-generated method stub
		return userLoginCrudRepo.save(userLoginDbDTO);
	}

	@Override
	public long countOfUser() {
		// TODO Auto-generated method stub
		
		
		return userLoginCrudRepo.count();
	}

}
