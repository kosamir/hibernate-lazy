package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.example.demo.model.enumeration.IntrestTypes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Interest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Enumerated(EnumType.STRING)
	private IntrestTypes interestTypes;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "personInterest")
	private Set<Person> persons;

	private LocalDateTime created;
	private LocalDateTime lastUpdated;

	@PrePersist
	public void prePersist() {
		created = LocalDateTime.now();
		lastUpdated = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		lastUpdated = LocalDateTime.now();
	}

	public Interest(IntrestTypes interestTypes) {
		super();
		this.interestTypes = interestTypes;
	}
	
	
	
	

}
