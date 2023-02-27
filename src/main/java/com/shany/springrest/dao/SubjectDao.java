package com.shany.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.ClassGroup;
import com.shany.springrest.model.Professor;
import com.shany.springrest.model.Subject;

public interface SubjectDao extends JpaRepository<Subject, Integer > {
	
}
