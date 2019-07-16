package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource(value = "classpath:test-data.properties")
@Data
public class ApplicationProperties {
	
	@Value("${guru.surname}")
	private String host;
	@Value("${guru.name}")
	private String ip;
	
    

}
