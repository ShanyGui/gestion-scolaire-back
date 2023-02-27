package com.shany.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shany.springrest.dao.EstablishmentDao;
import com.shany.springrest.dao.EventDao;
import com.shany.springrest.model.ClassRoom;
import com.shany.springrest.model.Establishment;
import com.shany.springrest.model.Event;

@RestController
@CrossOrigin("*")
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	EventDao eventdao;
	
	@PostMapping("/")
	public ResponseEntity<Event> addOne(@RequestBody Event event) {
		this.eventdao.save(event);
		return new ResponseEntity<Event>(event, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Event>> findAll() {
		return new ResponseEntity<List<Event>>(this.eventdao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> findOne(@PathVariable Integer id) {
		Optional<Event> optionEvent = this.eventdao.findById(id);
		return optionEvent.isPresent()
				? new ResponseEntity<Event>(optionEvent.get(), HttpStatus.OK)
				: new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/findbyestablishment/{id}")
	public ResponseEntity<List<Event>> findByEstablishment(@PathVariable Integer id) {
		return new ResponseEntity<List<Event>>(eventdao.findByEstablishmentId(id),HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletOne(@PathVariable Integer id) {
		this.eventdao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
