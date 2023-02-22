package com.shany.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shany.springrest.dao.ClassGroupDao;
import com.shany.springrest.model.ClassGroup;

@RestController
@RequestMapping("/classgroup")
public class ClassGroupController {

	@Autowired
	ClassGroupDao classgroupdao;
	
	@PostMapping("/add")
	public ResponseEntity<ClassGroup> addOne(@RequestBody ClassGroup classgroup) {
		this.classgroupdao.save(classgroup);
		return new ResponseEntity<ClassGroup>(classgroup,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ClassGroup>> findAll() {
		return new ResponseEntity<List<ClassGroup>>(classgroupdao.findAll(),HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable int id){
		this.classgroupdao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClassGroup> findOne(@PathVariable int id) {
		Optional<ClassGroup> optIncident = this.classgroupdao.findById(id);
		return new ResponseEntity<ClassGroup>(optIncident.get(),HttpStatus.OK);
	}
	
}