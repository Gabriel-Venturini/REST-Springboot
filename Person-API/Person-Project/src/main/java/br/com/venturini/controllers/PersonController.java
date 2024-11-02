package br.com.venturini.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.venturini.model.Person;
import br.com.venturini.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	// substitui isso:
	// private PersonServices service = new PersonServices();
	
	@RequestMapping(value = "/{id}", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Person findById(
			@PathVariable(value = "id") String id
			) throws Exception {
		return service.findById(id);
	}
	
	@RequestMapping( 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return service.findAll();
	}
	
	// Verbo POST
	// NAO É POSSIVEL ACESSAR VIA BROWSER, LOGO TEM QUE USAR O POSTMAN
	@RequestMapping(method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	// Verbo PUT
	// ENDPOINT
	@RequestMapping(method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}
	
	// Verbo DELETE
	@RequestMapping(value = "/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id){
		service.delete(id);
	}
}