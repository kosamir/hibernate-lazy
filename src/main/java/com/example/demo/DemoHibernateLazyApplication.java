package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ApplicationProperties;
import com.example.demo.model.Adress;
import com.example.demo.model.Person;
import com.example.demo.repsitory.PersonRepository;

@RestController
@SpringBootApplication
public class DemoHibernateLazyApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;
	@Autowired
	EntityManager emr;
	@Autowired
	ApplicationProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(DemoHibernateLazyApplication.class, args);
	}

	@RequestMapping("/hello_amir")
	String hello() {
		return "Hello World! JavaInterviewPoint2222222";
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("yjlyjyjvl");
		System.out.println("****HELO*******" + properties.getHost());
		System.out.println();
		List<Person> persons = (List<Person>) repository.findAll();
		for (Person person : persons) {
			System.out.println("0-->" + person);

			List<Adress> adress = repository.getPersonAdresses(person.getId());

			System.out.println("1-->" + adress.get(0));
//			Hibernate.initialize(person.getAdresses());
//			Adress a = person.getAdresses().iterator().next();
			person.removeAdress(adress.get(0));
			repository.save(person);

//			repository.getPersonAdresses(person.getId()).forEach(Adress::toString);

		}
//		System.out.println("after deleting");
//		repository.findAll().forEach(m->{
//			System.out.println(m);
//			System.out.println(m.getAdresses());
//		});
//		
//		System.out.println("****END*******"); 

		

	}

}
