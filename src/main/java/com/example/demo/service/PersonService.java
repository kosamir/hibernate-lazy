package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Interest;
import com.example.demo.model.Person;

public interface PersonService {
	
	List<Person> findByInterest(String interest);
	List <Person> findByName(String name);

}
