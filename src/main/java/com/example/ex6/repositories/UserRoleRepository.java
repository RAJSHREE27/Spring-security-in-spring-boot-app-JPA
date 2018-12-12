/* we need to find the roles of users here
 * so we will access this DB and find roles as per userid's
 */
/* roles obtained as per user id */

package com.example.ex6.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ex6.model.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	
	@Query("select r.role_name from UserRole r , User u where u.user_id=r.user_id AND u.user_id=?")
	public List<String> findRoleByUserId(String userId);
	
	
}
