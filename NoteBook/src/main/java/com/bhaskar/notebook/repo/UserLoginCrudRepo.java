package com.bhaskar.notebook.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bhaskar.notebook.dto.UserLoginDbDTO;
import com.bhaskar.notebook.dto.UserRegistrationDTO;

@Repository
public interface UserLoginCrudRepo extends CrudRepository<UserLoginDbDTO, String> {

	@Query(value = "SELECT * from user_login WHERE userid = :userid", nativeQuery = true)
	UserLoginDbDTO getPasswordFromDB(@Param("userid") String userid);

}
