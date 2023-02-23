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

import com.shany.springrest.dao.SubjectDao;
import com.shany.springrest.model.Subject;

@CrossOrigin("*")
@RestController
@RequestMapping("/subjects")
public class SubjectController {
	@Autowired
	SubjectDao subjectdao;

	@PostMapping("/add")
	public ResponseEntity<Subject> addOne(@RequestBody Subject subject) {
		this.subjectdao.save(subject);
		return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Subject>> findAll() {
		return new ResponseEntity<List<Subject>>(this.subjectdao.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletOne(@PathVariable Integer id) {
		this.subjectdao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Subject> findOne(@PathVariable Integer id) {
		Optional<Subject> optionSubject = this.subjectdao.findById(id);

		return optionSubject.isPresent() ? new ResponseEntity<Subject>(optionSubject.get(), HttpStatus.OK)
				: new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);

	}
}
