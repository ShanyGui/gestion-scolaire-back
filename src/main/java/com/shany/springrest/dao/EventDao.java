package com.shany.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shany.springrest.model.Event;

public interface EventDao extends JpaRepository<Event, Integer>{

}
