package br.com.venturini.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venturini.exceptions.ResourceNotFoundException;
import br.com.venturini.model.Person;
import br.com.venturini.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		logger.info("Finding all people...");
		
		return repository.findAll();
	}

	public Person findById(Long id) {
		
		logger.info("Finding person...");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!")); // 
	}
	
	public Person create(Person person) {
		
		logger.info("Creating person...");
		
		return repository.save(person);
	}
	
	public Person update(Person person) {
		// recupera as infos da pessoa, joga na entity, seta propriedades e atualiza
		logger.info("Updating person...");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting person...");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	
		repository.delete(entity);
	}
}
