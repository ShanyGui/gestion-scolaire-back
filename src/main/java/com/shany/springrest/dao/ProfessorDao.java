package com.shany.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.Professor;

public interface ProfessorDao extends JpaRepository<Professor, Integer>{

}
