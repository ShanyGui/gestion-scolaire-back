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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shany.springrest.dao.EstablishmentDao;
import com.shany.springrest.model.Establishment;

@CrossOrigin("*")
@RestController
@RequestMapping("/establishments")
public class EstablishmentController {
	@Autowired
	EstablishmentDao establishmentdao;

	@PostMapping("/")
	public ResponseEntity<Establishment> addOne(@RequestBody Establishment establishment) {
		this.establishmentdao.save(establishment);
		return new ResponseEntity<Establishment>(establishment, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<Establishment>> findAll() {
		return new ResponseEntity<List<Establishment>>(this.establishmentdao.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletOne(@PathVariable Integer id) {
		this.establishmentdao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Establishment> findOne(@PathVariable Integer id) {
		Optional<Establishment> optionEstablishment = this.establishmentdao.findById(id);
		return optionEstablishment.isPresent()
				? new ResponseEntity<Establishment>(optionEstablishment.get(), HttpStatus.OK)
				: new ResponseEntity<Establishment>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Establishment> update(@RequestBody Establishment establishment, @PathVariable Integer id) {
		Optional<Establishment> updateEstablishment = establishmentdao.findById(id);
		
		if(updateEstablishment.isPresent()) {
			updateEstablishment.get().setName(establishment.getName());
			updateEstablishment.get().setAdress(establishment.getAdress());
			updateEstablishment.get().setType(establishment.getType());
			updateEstablishment.get().setPhoneNumber(establishment.getPhoneNumber());
			//updateEstablishment.get().setLogo(establishment.getLogo());
			this.establishmentdao.save(updateEstablishment.get());
			return new ResponseEntity<Establishment>(establishment, HttpStatus.OK);
		} else {
			return new ResponseEntity<Establishment>(establishment, HttpStatus.NOT_FOUND);
		}
				 
	}
	
}
