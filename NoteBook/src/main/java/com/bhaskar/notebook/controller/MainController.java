package com.bhaskar.notebook.controller;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bhaskar.notebook.dto.UserLoginDbDTO;
import com.bhaskar.notebook.dto.LoginDTO;
import com.bhaskar.notebook.dto.SignUpDTO;
import com.bhaskar.notebook.service.UserLoginServices;
import com.bhaskar.notebook.service.UserRegistrationService;
import com.bhaskar.notebook.service.UserServices;





@RestController
public class MainController {
	
	@Autowired
	UserServices userservices;
	@Autowired
	UserRegistrationService userRegistrationService;
	@Autowired
	UserLoginServices userLoginServices;
	

	
	
	@PostMapping(path = "/login")
	public boolean validateLogin(@RequestBody LoginDTO loginDTO) 
	{
		System.out.println("loginBean= "+loginDTO.toString());
		
		return userservices.validateLogin(loginDTO);
		
		
	}
	
	@PostMapping(path = "/signup")
	public boolean signupController(@RequestBody SignUpDTO signUpdto) 
	{
		System.out.println("signUpdto = "+signUpdto.toString());
		
		
		return userservices.userSignUp(signUpdto);
		
		
	}
	
	@GetMapping(path = "/helloTextGet")
	public String printHelloGet() throws IOException, InterruptedException, ExecutionException 
	{
		System.out.println("dddh");
		
		return userservices.getDetails();
		
		
	}
	
	@GetMapping(path = "/abc")
	public String printHelloGetAbc() throws IOException, InterruptedException, ExecutionException 
	{
		System.out.println("dddh");
		
		return "dd";
		
		
	}


}
