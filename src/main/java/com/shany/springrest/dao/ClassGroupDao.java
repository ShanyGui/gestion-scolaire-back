package com.shany.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shany.springrest.model.ClassGroup;

public interface ClassGroupDao extends JpaRepository<ClassGroup, Integer> {

}
