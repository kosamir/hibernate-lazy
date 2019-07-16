package com.example.demo.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Adress;
import com.example.demo.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	@Query("select a from Adress a where person_id=:id")
	List<Adress> getPersonAdresses(Long id);

	
}
