package com.bhaskar.notebook.serviceimpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bhaskar.notebook.dto.UserLoginDbDTO;
import com.bhaskar.notebook.dto.LoginDTO;
import com.bhaskar.notebook.dto.SignUpDTO;
import com.bhaskar.notebook.dto.UserRegistrationDTO;
import com.bhaskar.notebook.repo.SignUpCrudRepo;
import com.bhaskar.notebook.repo.UserLoginCrudRepo;
import com.bhaskar.notebook.repo.UserRegistrationRepo;
import com.bhaskar.notebook.service.UserLoginServices;
import com.bhaskar.notebook.service.UserRegistrationService;
import com.bhaskar.notebook.service.UserServices;
import com.google.api.client.util.Data;




@Component("UserServicesImpl")
@Service
public class UserServicesImpl implements UserServices{
	String returnValue="";
	@Autowired
	SignUpCrudRepo signupRepo;
	@Autowired
	UserRegistrationRepo userRegistrationRepo;
	@Autowired
	UserRegistrationService userRegistrationService;
	@Autowired
	UserLoginServices userLoginServices;
	@Autowired
	UserLoginCrudRepo userLoginCrudRepo;
	

	@Override
	public boolean validateLogin(LoginDTO loginbean) {
		// TODO Auto-generated method stub
		boolean validLogin=false;
		String userId="";
		if(checkRmn(loginbean.getUsername()))
		{
			System.out.println("Mobile");
			userId=getUserIdFromMobile(loginbean.getUsername());
		}
		else
		{
			System.out.println("Email");
			userId=getUserIdFromEmail(loginbean.getUsername());	
		}
		
		validLogin=authennticateUserLogin(userId,loginbean);
		System.out.println("userId validateLogin="+userId);
		
		return validLogin;
	}

	private boolean authennticateUserLogin(String userId,LoginDTO loginbean) {
		// TODO Auto-generated method stub
		UserLoginDbDTO logindbDTO=userLoginCrudRepo.getPasswordFromDB(userId);
		
		return checkHashPass(loginbean.getPassword(),logindbDTO.getPassword());
	}

	@Override
	public String getLoginInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * public String findUseridFromRmnOrEmail(LoginDTO loginDTO) {
	 * System.out.println("findUseridFromRmnOrEmail"); String userId="";
	 * if(loginDTO.getMobile()!=null && !loginDTO.getMobile().isEmpty()) {
	 * System.out.println("email id found email= "+loginDTO.getMobile());
	 * userId=getUserIdFromMobile(loginDTO.getMobile()); } else
	 * if(loginDTO.getEmail()!=null && !loginDTO.getEmail().isEmpty()) {
	 * System.out.println("mobile   found = "+loginDTO.getEmail());
	 * userId=getUserIdFromEmail(loginDTO.getEmail()); }
	 * 
	 * 
	 * return userId; }
	 */
	
	public String getUserIdFromEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println("getUserIdFromEmail");
		String userId=null;
		
		UserRegistrationDTO userRegDTo=userRegistrationRepo.getUserIdFromEmailDB(email);
		
		userId=userRegDTo.getUserId();
		System.out.println("userId= "+userId);
		return userId;
	}

	public String getUserIdFromMobile(String mobile) {
		// TODO Auto-generated method stub
		System.out.println("getUserIdFromMobile");
		String userId=null;
		
		UserRegistrationDTO userRegDTo=userRegistrationRepo.getUserIdFromMobileDB(mobile);
		
		userId=userRegDTo.getUserId();
		System.out.println("userId= "+userId);
		return userId;
	}

	public boolean checkRmn(String username)
	{
		 String digitReqex="\\d+";
		return username.length()==10 && username.matches(digitReqex) ? true:false;
	
	}
	

	@Override
	public String getDetails() throws IOException, InterruptedException, ExecutionException  {
		// TODO Auto-generated method stub
		System.out.println("Inside getDetails");
		System.out.println(userRegistrationRepo.findAll().toString());
		System.out.println(userRegistrationRepo.findById("444").toString());
		
		
		return userRegistrationRepo.findById("444").toString();
	}

	@Override
	public boolean userSignUp(SignUpDTO signUpdto) {
		boolean isSaved=false;
		UserLoginDbDTO userLoginDbDTO=new UserLoginDbDTO();
		UserRegistrationDTO userregDTO=new UserRegistrationDTO();
		signUpdto.setUserId(getUniqueUserIdService());
		signUpdto.setPassword(hashPassword(signUpdto.getPassword()));
		
		userregDTO=userRegistrationService.userRegistration(convertSignUpToUserRegistration(signUpdto));
		userLoginDbDTO=userLoginServices.saveUserLogin(convertSignUpToUserLogin(signUpdto));
		if(userregDTO!=null &&userLoginDbDTO!=null )
		isSaved=true;
		
		return isSaved;
	}
	
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	public boolean checkHashPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
		{	System.out.println("The password matches.");
		return true;
		}
		else
			{System.out.println("The password does not match.");
			return false;
			}
			
	}

	public String getOtpService() {
		// TODO Auto-generated method stubcv
		Random random=new Random();
		int otp=random.nextInt(9999);
		System.out.println("otp= "+otp);
		
		return String.valueOf(otp);
	}

	public String getUniqueUserIdService() {
		// TODO Auto-generated method stub
		long uniqueid=userLoginServices.countOfUser()+1;
		System.out.println("uniqueid "+uniqueid);
		
		return String.valueOf(uniqueid);
	}

	public String getDateofRegister() {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-YY HH:mm");
		String todayDate=simpleDateFormat.format(new Date());
		System.out.println("todayDate"+todayDate);
		
		return todayDate;
	}

	public UserLoginDbDTO convertSignUpToUserLogin(SignUpDTO signUpdto){
		UserLoginDbDTO userLoginDbDTO=new UserLoginDbDTO();
		
		userLoginDbDTO.setUserId(signUpdto.getUserId());
		userLoginDbDTO.setPassword(signUpdto.getPassword());
		userLoginDbDTO.setLastupdated(getDateofRegister());
		return userLoginDbDTO;
	}

	public UserRegistrationDTO convertSignUpToUserRegistration(SignUpDTO signUpdto) {
	
	UserRegistrationDTO userregDTO=new UserRegistrationDTO();
		userregDTO.setName(signUpdto.getName());
		userregDTO.setMobile(signUpdto.getMobile());
		userregDTO.setEmail(signUpdto.getEmail());
		userregDTO.setUserId(signUpdto.getUserId());
		
		userregDTO.setDateOfRegister(getDateofRegister());
		userregDTO.setOtp(getOtpService());
	  return userregDTO;
	}
	
	
	

	private SignUpDTO authenticateSignUpInput(SignUpDTO signUpdto) {
		// TODO Auto-generated method stub
		
		return null;
	}



}
