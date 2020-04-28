package com.bhaskar.notebook.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "user_registration")
public class UserRegistrationDTO {

	   @Id
	   @Column(name="userid")
		private String userId;
		private String name;
		private String mobile;
		private String email;
		@Column(name="dateofreg")
		private String dateOfRegister;
		private String otp;
		
		

	
}
