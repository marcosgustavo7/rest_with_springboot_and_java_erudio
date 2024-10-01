package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		return repository.findAll();
		
	}

		public Person findByID(Long id) {
		
		logger.info("Finding one person!");

		return repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		} 
		
		
		public Person create(Person person) {
			
		logger.info("Creating one person!");
		return repository.save(person);
	}
		
		
		public Person update(Person person) {
			logger.info("Updating one person!");
			
			var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
			
			entity.setFirstName(person.getFirstName());
			entity.setLastName(person.getLastName());
			entity.setGender(person.getGender());
			entity.setAddress(person.getAddress());
			
			return repository.save(person);
		}
		
		
		public void delete(Long id) {
			
			logger.info("Deleting one person!");
			
			var entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

			repository.delete(entity);
		}
		
/*		private Person mockPerson(int i) {
			
				
				logger.info("Finding one person!");
				Person person = new Person();
				person.setId(counter.incrementAndGet());
				person.setFirstName("Person name " + i);
				person.setLastName("Last name " + i);
				person.setGender("Male");
				person.setAddress("Some address in Brazil " + i);
				return person;
			}*/
	}
	

