package com.shany.springrest.model;

import jakarta.persistence.Entity;
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
	private int id;
	
	@NonNull
	private String name;
	
	//A FAIRE SI ON A DU TEMPS
	//private String matieresExclues;
	
	private int capacity;
	
	@ManyToOne
	private Establishment establishment;
}
