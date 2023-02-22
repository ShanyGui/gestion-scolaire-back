package com.shany.springrest.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Professor {

	private int id;
	private String lastname;
	private String firstname;
	private Date dateOfBirth;
	private List<Subject> subjects;
	
}
