package com.shany.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.ClassGroup;
import com.shany.springrest.model.Professor;

public interface ProfessorDao extends JpaRepository<Professor, Integer>{

	public List<Professor> findByEstablishmentId(Integer establishmentId);
	
}
