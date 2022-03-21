package br.com.mercadolivre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.dto.PersonDTO;
import br.com.mercadolivre.dto.SportsPersonDTO;
import br.com.mercadolivre.model.Person;
import br.com.mercadolivre.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping
	public ResponseEntity<List<PersonDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/findSportsPersons")
	public ResponseEntity<List<SportsPersonDTO>> findSportsPerson() throws Exception {
		return ResponseEntity.ok(service.findSportsPersons());
	}

	@PostMapping
	public ResponseEntity<Person> register(@RequestBody PersonDTO dto) throws Exception {
		return new ResponseEntity<>(service.register(dto), HttpStatus.CREATED);
	}
	
}
