package com.bhaskar.notebook.repo;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bhaskar.notebook.dto.UserRegistrationDTO;

@Repository
public interface UserRegistrationRepo extends CrudRepository<UserRegistrationDTO, String> {
	
	@Query(value = "SELECT * from user_registration WHERE email = :email", nativeQuery = true)
	UserRegistrationDTO getUserIdFromEmailDB(@Param("email") String email);

	@Query(value = "SELECT * from user_registration WHERE mobile = :mobile", nativeQuery = true)
	UserRegistrationDTO getUserIdFromMobileDB(String mobile);
	
	@Query(value = "SELECT * from user_registration WHERE userid = :userid", nativeQuery = true)
	UserRegistrationDTO checkUserPresentInDB(@Param("userid") String userid);

}
