package com.example.model.user;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {


	@Id
	private String name;
	private String password;

	public User(){

	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
