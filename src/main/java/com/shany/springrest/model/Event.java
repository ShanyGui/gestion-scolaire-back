package com.shany.springrest.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NonNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startHour;
	
	@NonNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endHour;
	
	@ManyToOne
	@JsonIgnore
	private Professor professor;
	
	@ManyToOne
	@JsonIgnore
	private Subject subject;
	
	@ManyToOne
	@JsonIgnore
	private Establishment establishment;
}
