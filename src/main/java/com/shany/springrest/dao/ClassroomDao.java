package com.shany.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.ClassGroup;
import com.shany.springrest.model.ClassRoom;

public interface ClassroomDao extends JpaRepository<ClassRoom, Integer>{
	
	public List<ClassRoom> findByEstablishmentId(Integer establishmentId);
	
}
