package com.shany.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.ClassRoom;

public interface ClassroomDao extends JpaRepository<ClassRoom, Integer>{

}
