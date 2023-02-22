package com.shany.springrest.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
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
	private int id;
	
	@NonNull
	private String lastname;
	
	@NonNull
	private String firstname;
	
	@NonNull
	private Date dateOfBirth;
	
	
	@ManyToMany(mappedBy = "professors")
	@JsonIgnoreProperties("professors")
	private List<Subject> subjects;
	
	@OneToOne
	private ClassGroup principalClass;
	
	@ManyToOne
	private Establishment establishment;
	
}
