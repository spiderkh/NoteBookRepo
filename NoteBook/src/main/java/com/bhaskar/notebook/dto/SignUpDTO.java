package com.bhaskar.notebook.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class SignUpDTO {
	@Id
	private String userId;
	private String name;
	private String mobile;
	private String email;
	private String password;
	private String dateOfRegister;
	private String otp;
	
	

}
