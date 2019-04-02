package com.cts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medical_services")
public class MedicalServices {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="Service_Name",length=50)
	String name;
	
	@Column(name="Description",length=200)
	String description;
	
	@Column(name="Amount")
	int amount;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getAmount() {
		return amount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public MedicalServices(int id, String name, String description, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
	}

	public MedicalServices() {
		super();
	}
	

}
