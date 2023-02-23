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

import com.shany.springrest.dao.ProfessorDao;
import com.shany.springrest.dao.SubjectDao;
import com.shany.springrest.model.Professor;

@CrossOrigin("*")
@RestController
@RequestMapping("/professors")
public class ProfessorController {
	@Autowired
	ProfessorDao professordao;
	@Autowired
	SubjectDao subjectdao;

	@PostMapping("/")
	public ResponseEntity<Professor> addOne(@RequestBody Professor professor) {
		this.professordao.save(professor);
		
		return new ResponseEntity<Professor>(professor, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Professor>> findAll() {
		return new ResponseEntity<List<Professor>>(this.professordao.findAll(), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletOne(@PathVariable Integer id) {
		this.professordao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Professor> findOne(@PathVariable Integer id) {
		Optional<Professor> optionProfessor = this.professordao.findById(id);

		return optionProfessor.isPresent() ? new ResponseEntity<Professor>(optionProfessor.get(), HttpStatus.OK)
				: new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);

	}
}
