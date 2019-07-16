package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repsitory.PersonRepository;
import com.example.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private EntityManager manager;
	private PersonRepository personRepository;
	



	public PersonServiceImpl(EntityManager manager, PersonRepository personRepository) {
		super();
		this.manager = manager;
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> findByInterest(String interest) {
		List<Person>  person = StreamSupport.stream(personRepository.findAll().spliterator(), false)
				.filter(p->{
								p.getPersonInterest().stream().filter(intrest -> {
											if(intrest.getInterestTypes().toString().equalsIgnoreCase(interest)) {
												return true;
											}
											return false;
								}).findFirst();
				return true;
		}).collect(Collectors.toList());
		
		return person;
		
	}

	@Override
	public List<Person> findByName(String name) {
		// TODO Auto-generated method stub
		return StreamSupport.stream(personRepository.findAll().spliterator(), false)
				.filter(person -> person.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
	}

}
