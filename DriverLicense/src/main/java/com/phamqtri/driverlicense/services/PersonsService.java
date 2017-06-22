package com.phamqtri.driverlicense.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.phamqtri.driverlicense.models.PersonModel;
import com.phamqtri.driverlicense.repositories.PersonsRepository;

@Service
public class PersonsService {
	private PersonsRepository personRepository;
	
	public PersonsService(PersonsRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public ArrayList<PersonModel> allPersons() {
		return this.personRepository.findAll();
	}
	
	public PersonModel findPersonById(long id) {
		return this.personRepository.findOne(id);
	}
	
	public void createPerson(PersonModel person) {
		this.personRepository.save(person);
	}
	
	public void destroyPerson(long id) {
		if (this.personRepository.findOne(id) != null) {
			this.personRepository.delete(id);
		}
	}
	
	public void updatePerson(long id, PersonModel person) {
		if (this.personRepository.findOne(id) != null) {
			this.personRepository.save(person);
		}
	}
}
