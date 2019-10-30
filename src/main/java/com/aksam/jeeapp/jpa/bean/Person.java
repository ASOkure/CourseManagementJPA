package com.aksam.jeeapp.jpa.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;


@ManagedBean (name="person")
@RequestScoped
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "first_name")
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getFirstName() {
	return firstName;
	}
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	public String getLastName() {
	return lastName;
	}
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	}
