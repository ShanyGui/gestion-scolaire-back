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

import com.shany.springrest.dao.ClassroomDao;
import com.shany.springrest.model.ClassGroup;
import com.shany.springrest.model.ClassRoom;

@CrossOrigin("*")
@RestController
@RequestMapping("/classrooms")
public class ClassroomController {

	@Autowired
	ClassroomDao classroomdao;
	
	@PostMapping("/")
	public ResponseEntity<ClassRoom> addOne(@RequestBody ClassRoom classroom) {
		this.classroomdao.save(classroom);
		return new ResponseEntity<ClassRoom>(classroom,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ClassRoom>> findAll() {
		return new ResponseEntity<List<ClassRoom>>(classroomdao.findAll(),HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClassRoom> findOne(@PathVariable Integer id) {
		Optional<ClassRoom> optIncident = this.classroomdao.findById(id);
		return new ResponseEntity<ClassRoom>(optIncident.get(),HttpStatus.OK);
	}
	
	@GetMapping("/findbyestablishment/{id}")
	public ResponseEntity<List<ClassRoom>> findByEstablishment(@PathVariable Integer id) {
		return new ResponseEntity<List<ClassRoom>>(classroomdao.findByEstablishmentId(id),HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable Integer id){
		this.classroomdao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
