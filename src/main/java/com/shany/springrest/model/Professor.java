package com.shany.springrest.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	private String lastname;
	
	@NonNull
	private String firstname;
	
	@NonNull
	private Date dateOfBirth;
	
	@OneToMany(mappedBy = "professors")
	private List<Subject> subjects;
	
	private ClassGroup principalClass;
	
}
