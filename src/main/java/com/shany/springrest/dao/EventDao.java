package com.shany.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.ClassRoom;
import com.shany.springrest.model.Event;

public interface EventDao extends JpaRepository<Event, Integer>{

	public List<Event> findByEstablishmentId(Integer establishmentId);
	
}
