package com.shany.springrest.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Subject {

	private int id;
	private String name;
	private String color;
	private List<Professor> professors;
}
