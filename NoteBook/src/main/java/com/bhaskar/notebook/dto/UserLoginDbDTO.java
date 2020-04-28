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
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_login")
public class UserLoginDbDTO {
	
	@Id
	@Column(name="userid")
	private String userId;
	private String password;
	private String lastupdated;
	
}
