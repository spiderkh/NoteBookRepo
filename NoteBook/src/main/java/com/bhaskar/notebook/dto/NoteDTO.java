package com.bhaskar.notebook.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "note")
public class NoteDTO {
	
    @Id
    private String noteid;
    @Column(name="authorid")
	private String authorid; 
	private String text; 
	private String timeoftext;
}
