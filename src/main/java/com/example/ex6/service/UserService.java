 /*to create classes required for spring security to use the data
 returned by the user repositories to authenticate users
*/

package com.example.ex6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ex6.model.User;
import com.example.ex6.repositories.UserRepository;
import com.example.ex6.repositories.UserRoleRepository;

@Service("user_service")
public class UserService implements UserDetailsService {
	
	//variables
	
	private final UserRepository user_repository;
	private final UserRoleRepository user_role_repository;
	
	@Autowired
	public UserService(UserRepository user_repository, UserRoleRepository user_role_repository) {
		
		this.user_repository = user_repository;
		this.user_role_repository = user_role_repository;
		
	}
	
	@Override
	public UserDetails loadUserByUsername(final String userId) throws UsernameNotFoundException{
		
		User user = user_repository.findByUserId(userId);
		
		if(null == user) {
			throw new UsernameNotFoundException("Invalid User");
		}
		else {
			//if user found then lost various roles of user
			List <String> user_roles = user_role_repository.findRoleByUserId(userId);			
			
			return new CustomUserDetails(user,user_roles);
		}
		
	}
	
	
	
	
	
}
