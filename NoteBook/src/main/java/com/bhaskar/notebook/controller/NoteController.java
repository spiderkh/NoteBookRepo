package com.bhaskar.notebook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhaskar.notebook.dto.NoteDTO;
import com.bhaskar.notebook.dto.SignUpDTO;
import com.bhaskar.notebook.service.NoteService;

@RestController
public class NoteController {
	
	@Autowired
	NoteService noteService;

	@PostMapping(path = "/saveNote")
	public NoteDTO saveNoteToDB(@RequestBody NoteDTO noteDTO) 
	{
		return noteService.ValidateNote(noteDTO);
		
		
		
	}
	@PostMapping(path = "/getAllNote")
	public String getAllNoteOfUser(@RequestBody String userId) 
	{
		System.out.println("getAllNoteOfUser");
		System.out.println("userId= "+userId);
		return noteService.getAllNoteofUserId(userId).toString();
		
		
		
	}
	
}
