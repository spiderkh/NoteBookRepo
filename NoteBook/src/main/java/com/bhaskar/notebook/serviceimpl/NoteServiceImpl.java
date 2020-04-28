package com.bhaskar.notebook.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhaskar.notebook.dto.NoteDTO;
import com.bhaskar.notebook.dto.UserRegistrationDTO;
import com.bhaskar.notebook.repo.NoteCrudRepo;
import com.bhaskar.notebook.repo.UserRegistrationRepo;
import com.bhaskar.notebook.service.NoteService;
import com.bhaskar.notebook.service.UserServices;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NoteCrudRepo noteCrudRepo;
	@Autowired
	UserServices userServices;
	@Autowired
	UserRegistrationRepo  userRegistrationRepo;

	@Override
	public NoteDTO saveNoteToDB(NoteDTO noteDTO) {
		// TODO Auto-generated method stub
		return noteCrudRepo.save(noteDTO);
	}

	@Override
	public NoteDTO ValidateNote(NoteDTO noteDTO) {
		// TODO Auto-generated method stub
		UserRegistrationDTO userReg=userRegistrationRepo.checkUserPresentInDB(noteDTO.getAuthorid());
		
		System.out.println("ValidateNote "+userReg.toString());
		if(userReg!=null)
			{System.out.println("Author Found");
			noteDTO.setTimeoftext(userServices.getDateofRegister());
			noteDTO.setNoteid(getUniqueNoteIdService());
			noteDTO=saveNoteToDB(noteDTO);
			  
			}
			
		 System.out.println("noteDTO= "+noteDTO.toString());
		return noteDTO;
	}

	@Override
	public String getUniqueNoteIdService() {
		// TODO Auto-generated method stub
		return String.valueOf(noteCrudRepo.count()+1);
	}

	@Override
	public List<NoteDTO> getAllNoteofUserId(String userId) {
		// TODO Auto-generated method stub
		
		return noteCrudRepo.findByAuthorid(userId);
	}

}
