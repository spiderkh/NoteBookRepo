package com.bhaskar.notebook.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bhaskar.notebook.dto.NoteDTO;

public interface NoteCrudRepo extends CrudRepository<NoteDTO, String> {
	
	
	List<NoteDTO> findByAuthorid(String authorid);


}
