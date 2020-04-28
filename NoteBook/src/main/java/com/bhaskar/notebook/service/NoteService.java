package com.bhaskar.notebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bhaskar.notebook.dto.NoteDTO;

public interface NoteService {
	public NoteDTO saveNoteToDB(NoteDTO noteDTO);
	public NoteDTO ValidateNote(NoteDTO noteDTO);
	public String getUniqueNoteIdService();
	public List<NoteDTO> getAllNoteofUserId(String userId);

}
