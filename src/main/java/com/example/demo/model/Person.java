package com.example.demo.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"id","name"})
@Entity
@NoArgsConstructor
@ToString(of = {"name","surName","brithDay"})
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String surName;
//	@Column
//	@Convert(converter =  DateConverter.class)
	private Date brithDay;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Set<Adress> adresses = new HashSet<Adress>();
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(	name="person_interest", 
				joinColumns = @JoinColumn(name="person_id"),
				inverseJoinColumns = @JoinColumn(name="interest_id"))
	private Set<Interest> personInterest = new HashSet<Interest>();
	
	
	
	
	
	public void addAdress(Adress adress) {
		adresses.add(adress);
		adress.setPerson(this);
	}
	
	public void removeAdress(Adress adress) {
		boolean tst = adresses.remove(adress);
		adress.setPerson(null);
	}
	

}
