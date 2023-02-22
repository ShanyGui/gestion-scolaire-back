package com.shany.springrest.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Establishment {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String adress;
	
	@Enumerated (EnumType.STRING)
	private EstablishmentType type;
	
	private String phoneNumber;
	
	private String logo;
	
	@OneToMany(mappedBy = "establishment")
	private List<Professor> professors;
	
	@OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL)
	private List<ClassRoom> classrooms;
	
	@OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL)
	private List<ClassGroup> classgroups;
	
}
