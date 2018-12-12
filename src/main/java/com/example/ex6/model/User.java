package com.example.ex6.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="User")
public class User {
	
	
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="e_mail")
	private String email;
	
	public User(String userId, String password, String email) {
		this.userId = userId;
		this.password = password;
		this.email = email;
	}

	public User(User user) {
		// TODO Auto-generated constructor stub
	}
	
}
