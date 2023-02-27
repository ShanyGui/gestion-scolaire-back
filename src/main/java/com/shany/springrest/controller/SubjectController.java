package com.shany.springrest.controller;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shany.springrest.dao.SubjectDao;
import com.shany.springrest.model.ClassGroup;
import com.shany.springrest.model.Professor;
import com.shany.springrest.model.Subject;

@CrossOrigin("*")
@RestController
@RequestMapping("/subjects")
public class SubjectController {
	@Autowired
	SubjectDao subjectdao;

	@PostMapping("/")
	public ResponseEntity<Subject> addOne(@RequestBody Subject subject) {
		this.subjectdao.save(subject);
		return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Subject>> findAll() {
		return new ResponseEntity<List<Subject>>(this.subjectdao.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subject> findOne(@PathVariable Integer id) {
		Optional<Subject> optionSubject = this.subjectdao.findById(id);
		return optionSubject.isPresent() ? new ResponseEntity<Subject>(optionSubject.get(), HttpStatus.OK)
				: new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
	}
/*	
	@GetMapping({"/findbyprofessors/", "/findbyprofessors"})
	public ResponseEntity<List<Subject>> findByProfessors(@RequestBody List<Professor> professors) {

		List<Subject> returnedSubjects = new ArrayList<>();
		List<Subject> professorSubjects = new ArrayList<>();
		
		for (Professor professor : professors) {
			professorSubjects = (subjectdao.findByProfessors(professors));
			for (Subject subject : professorSubjects) {
				returnedSubjects.add(subject);
			}
		}
		
		return new ResponseEntity<List<Subject>>(returnedSubjects,HttpStatus.OK);

	}
*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletOne(@PathVariable Integer id) {
		this.subjectdao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
}
