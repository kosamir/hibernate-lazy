package com.example.demo.bootstrap;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import com.example.demo.model.Adress;
import com.example.demo.model.Interest;
import com.example.demo.model.Person;
import com.example.demo.model.enumeration.IntrestTypes;
import com.example.demo.repsitory.InterestRepostory;
import com.example.demo.repsitory.PersonRepository;
import com.example.demo.service.PersonService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private final PersonRepository personRepository;
	private final InterestRepostory interestRepostory;
	
//	@Qualifier("personServiceImpl")
	private final PersonService personService;
	
	
	private void fillPersonsAndAddIntersts() {
		Person p = new Person();
		p.setName("Amir");
		p.setSurName("Kos");
//		p.setBrithDay(LocalDate.of(2000, 5, 25));
		p.setBrithDay( Date.valueOf(LocalDate.now()));
		
		p.addAdress(new Adress("miramarska 15c", "zagreb"));
		p.addAdress(new Adress("petrinjska 16c", "crikvenica"));
		p.addAdress(new Adress("gunduliceva 16c", "miljkovici"));
		
//		p.getPersonInterest().addAll(interestRepostory.findAll().stream().collect(Collectors.toSet()));
		p.getPersonInterest().add(new Interest(IntrestTypes.FISHING));

		
		personRepository.save(p);
		
		Person p1 = new Person();
		p1.setName("Petar");p1.setSurName("Pan");
//		p.setBrithDay(LocalDate.of(2000, 5, 25));
		p1.setBrithDay( Date.valueOf(LocalDate.now()));
		
		p1.addAdress(new Adress("miramarska 15c", "zagreb"));
		p1.addAdress(new Adress("petrinjska 16c", "crikvenica"));
		
//		p1.setPersonInterest(interestRepostory.findAll(Example.of(new Interest(IntrestTypes.FISHING))).stream().collect(Collectors.toSet()));
		
		p1.getPersonInterest().add(new Interest(IntrestTypes.FISHING));
		
		
		personRepository.save(p1);
		
		Person petar = new Person();
		petar.setName("Domagoj");petar.setSurName("Pecinari");
//		p.setBrithDay(LocalDate.of(2000, 5, 25));
		petar.setBrithDay( Date.valueOf(LocalDate.now()));
		
		petar.addAdress(new Adress("miramarska 15c", "zagreb"));
		petar.addAdress(new Adress("petrinjska 16c", "crikvenica"));
		
//		p1.setPersonInterest(interestRepostory.findAll(Example.of(new Interest(IntrestTypes.FISHING))).stream().collect(Collectors.toSet()));
		
		petar.getPersonInterest().add(new Interest(IntrestTypes.FISHING));
		
		
		personRepository.save(petar);
	}
	
	private void deletePersonIntersts() {
		
	}
	
	private void fillInterests() {
		Interest fishing = new Interest();
		fishing.setInterestTypes(IntrestTypes.FISHING);
		Interest sports = new Interest();
		sports.setInterestTypes(IntrestTypes.SPORT);
		Interest reading = new Interest();
		reading.setInterestTypes(IntrestTypes.READING); 
		
		interestRepostory.saveAll(Arrays.asList(fishing, sports, reading));
		
		
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.debug("On application event fires");
		
		fillInterests();
		fillPersonsAndAddIntersts();
		personRepository.findAll().forEach(System.out::println);
		
		interestRepostory.findAll().stream().forEach(System.out::println);
		
		List <Person> sameInterest = personService.findByInterest(IntrestTypes.FISHING.toString());
		for(Person person : sameInterest) {
			System.out.println(person);
		}
		
		List<Person> sameName = personService.findByName("Petar");
		for(Person p: sameName)
			System.out.println(p);
		
		
		
		
		
		
		
		
	}

}
