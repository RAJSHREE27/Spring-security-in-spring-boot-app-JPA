/* users obtained as per ID */

package com.example.ex6.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ex6.model.User;


@Repository
public interface UserRepository extends CrudRepository<User , Long> {
	
	public User findByUserId(String userId);
	
}
