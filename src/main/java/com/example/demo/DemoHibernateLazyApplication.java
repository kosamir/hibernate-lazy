package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.ApplicationProperties;
import com.example.demo.repsitory.PersonRepository;

@RestController
@SpringBootApplication
public class DemoHibernateLazyApplication extends SpringBootServletInitializer  {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	ApplicationProperties properties;

	public static void main(String[] args) {
		SpringApplication.run(DemoHibernateLazyApplication.class, args);
	}

	@RequestMapping("/hello_amir")
	String hello() {
		return "Hello World! JavaInterviewPoint2222222";
	}

	
		

	}


