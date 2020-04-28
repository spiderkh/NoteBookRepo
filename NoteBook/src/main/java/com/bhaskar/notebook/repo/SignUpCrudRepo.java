package com.bhaskar.notebook.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bhaskar.notebook.dto.SignUpDTO;

@Repository
public interface SignUpCrudRepo extends CrudRepository<SignUpDTO, String> {
	
	

}
