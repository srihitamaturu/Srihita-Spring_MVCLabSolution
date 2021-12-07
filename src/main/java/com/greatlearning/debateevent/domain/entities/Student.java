package com.greatlearning.debateevent.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	private String department;

	@Column(name = "country")
	private String country;

	//For create call
	public Student(String name, String department, String country) {
		this.name = name;
		this.department = department;
		this.country = country;
	}

	//For update call
	public Student(int id, String name, String department, String country) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.country = country;
	}

	public Student() {
		// Empty Constructor to handle input from Webform
	}

	@Override
	public String toString() {
		return "Students [id=" + getId() + ", name=" + getName() + ", department=" + getDepartment() + ", country="
				+ getCountry() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
