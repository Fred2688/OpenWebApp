package com.example.model.alcohol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Drink {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name ="alcohol")
    @JsonBackReference
	private Alcohol alcohol;
	
	public Drink() {
		
	}
	
	public Drink(String name, Alcohol alcohol) {
		super();
		this.name = name;
		this.alcohol = alcohol;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
