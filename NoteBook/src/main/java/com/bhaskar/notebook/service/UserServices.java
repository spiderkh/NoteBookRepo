package com.bhaskar.notebook.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.bhaskar.notebook.dto.UserLoginDbDTO;
import com.bhaskar.notebook.dto.LoginDTO;
import com.bhaskar.notebook.dto.SignUpDTO;
import com.bhaskar.notebook.dto.UserRegistrationDTO;


public interface UserServices {
	
	public boolean validateLogin(LoginDTO loginbean);
	public String  getLoginInfo(String username);
	public String getDetails() throws IOException, InterruptedException, ExecutionException;
	public boolean userSignUp(SignUpDTO signUpdto);
	public String getOtpService();
	public String getUniqueUserIdService();
	public String getDateofRegister();
	public UserLoginDbDTO convertSignUpToUserLogin(SignUpDTO signUpdto);
	public UserRegistrationDTO convertSignUpToUserRegistration(SignUpDTO signUpdto);
	public String hashPassword(String plainTextPassword);
	public boolean checkHashPass(String plainPassword, String hashedPassword);
	public String getUserIdFromEmail(String email);
	public String getUserIdFromMobile(String mobile);
	

}
