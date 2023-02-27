package com.shany.springrest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NonNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startHour;
	
	@NonNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endHour;
	
	@ManyToOne
	private Professor professor;
	
	@ManyToOne
	private Subject subject;
	
	@ManyToOne
	private Establishment establishment;
}
