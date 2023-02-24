package com.shany.springrest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	private String name;
	
	//A FAIRE SI ON A DU TEMPS
	//private String matieresExclues;
	
	@NonNull
	private Integer capacity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"professors", "classgroups", "classrooms"})
	private Establishment establishment;
}
