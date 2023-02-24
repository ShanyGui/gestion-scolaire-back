package com.shany.springrest.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	private String lastname;
	
	@NonNull
	private String firstname;
	
	@NonNull
	private String dateOfBirth;
	
	@ManyToMany
	@JsonIgnoreProperties("professors")
	private List<Subject> subjects;
	
	@OneToOne(mappedBy = "principalProfessor")
	@JsonIgnoreProperties("principalProfessor")
	private ClassGroup principalClass;
	
	@ManyToOne
	@JsonIgnoreProperties({"classgroups","classrooms","professors"})
	private Establishment establishment;
	
}
