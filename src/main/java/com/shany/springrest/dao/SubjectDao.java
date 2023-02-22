package com.shany.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.Subject;

public interface SubjectDao extends JpaRepository<Subject, Integer > {

}
