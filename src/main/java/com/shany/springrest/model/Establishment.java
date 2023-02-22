package com.shany.springrest.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Establishment {

	private int id;
	private String name;
	private String adress;
	private EstablishmentType type;
	private String phoneNumber;
	private String logo;
	
	
	
}
