package com.example.ex6.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="UserRole")
public class UserRole {
	
	@Id
	@Column(name="role_id")
	private String roleId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="role_name")
	private String roleName;
	
	
}
