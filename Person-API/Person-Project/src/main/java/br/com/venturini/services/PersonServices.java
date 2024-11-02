package br.com.venturini.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.venturini.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		
		logger.info("Finding all people...");
		
		// declara listagem de pessoas
		List<Person> persons = new ArrayList<>();
		
		// itera em um array de 0 a 8
		for (int i = 0; i < 8; i++) {
			// mocka uma pessoa para essa lista
			Person person = mockPerson(i);
			// adiciona essa pessoa para a lista persons
			persons.add(person);
		}
		
		return persons;
	}

	public Person findById(String id) {
		
		logger.info("Finding person...");
		
		Person person = new Person();
		
		// mock
		person.setId(counter.incrementAndGet());
		person.setFirstName("Gabriel");
		person.setLastName("Venturini");
		person.setAddress("São Paulo, SP - Brasil");
		person.setGender("M");
		
		return person;
	}
	
	public Person create(Person person) {
		
		logger.info("Creating person...");
		
		return person;
	}
	
	public Person update(Person person) {
			
		logger.info("Updating person...");
		
		return person;
	}
	
	public void delete(String id) {
		
		logger.info("Deleting person...");
	}
	
	private Person mockPerson(int i) {
		
		// mock
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		if (i % 2 == 0) {
			person.setGender("F");
		}
		else {person.setGender("M");}
		
		return person;
	}
}
