package com.example.ex6.service;

import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.ex6.model.User;

@Service
public class CustomUserDetails extends User implements UserDetails {
	

	private static final long serialVersionUID = 1L;
	
	private List<String> user_roles;
	
	public CustomUserDetails(User user, List<String>user_roles) {
		super(user);
		this.user_roles = user_roles;
	}
	
	@Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
	  
	  String roles=StringUtils.collectionToCommaDelimitedString(user_roles);   
	  
	  return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	
	}
	

	 @Override
	 public boolean isAccountNonExpired() {  
	  return true;
	 }
	 
	 @Override
	 public boolean isAccountNonLocked() {
	  return true;
	 }
	 
	 @Override
	 public boolean isCredentialsNonExpired() {
	  return true;
	 }
	 
	 @Override
	 public boolean isEnabled() {
	  return true;
	 }
	

	@Override
	public String getUsername() {
		
		 return super.getUserId();
	}

	
}
