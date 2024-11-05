package br.com.venturini.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.venturini.model.Person;
import br.com.venturini.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	// substitui isso:
	// private PersonServices service = new PersonServices();
	
	// Endpoint para buscar uma pessoa por ID
		@GetMapping(value = "/{id}", 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Person findById(
				@PathVariable(value = "id") Long id
				) {
			return service.findById(id);
		}
		
		// Endpoint para buscar todas as pessoas
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Person> findAll() {
			return service.findAll();
		}
	
	// Verbo POST
	// NAO É POSSIVEL ACESSAR VIA BROWSER, LOGO TEM QUE USAR O POSTMAN
	@PostMapping(
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	// Verbo PUT
	// ENDPOINT
	@PutMapping(
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	// Verbo DELETE
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		service.delete(id);
		return ResponseEntity.noContent().build(); // retorna o 204
	}
}