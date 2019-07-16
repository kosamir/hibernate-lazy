  package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = {"adress","city"})
@EqualsAndHashCode(of = {"id","adress"})
@Entity
@NoArgsConstructor
public class Adress {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String adress;
	
	private String city;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	private Person person;
	
	public Adress(String adress, String city) {
		this.adress = adress;
		this.city = city;
	}

}
