package br.com.mercadolivre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.dto.SportDTO;
import br.com.mercadolivre.model.Sport;
import br.com.mercadolivre.service.SportService;

@RestController
@RequestMapping("/sport")
public class SportController {

	@Autowired
	private SportService service;

	@GetMapping
	public ResponseEntity<List<Sport>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{name}")
	public ResponseEntity<String> findByName(@PathVariable String name) throws Exception {
		return ResponseEntity.ok(service.findByName(name).getLevel().toString());
	}

	@PostMapping
	public ResponseEntity<Sport> register(@RequestBody SportDTO dto) {
		return new ResponseEntity<>(service.register(dto), HttpStatus.CREATED);
	}

}
