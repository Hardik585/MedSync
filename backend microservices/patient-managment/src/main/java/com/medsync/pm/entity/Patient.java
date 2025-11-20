package com.medsync.pm.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	
	@NotNull
	private LocalDate birthDate;
	
	@NotNull
	private LocalDate RegisterDate;
     
	
	 
	public Patient(UUID id, @NotNull String name, @NotNull @Email String email, @NotNull LocalDate birthDate,
			@NotNull LocalDate registerDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		RegisterDate = registerDate;
	}

	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getRegisterDate() {
		return RegisterDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		RegisterDate = registerDate;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate
				+ ", RegisterDate=" + RegisterDate + "]";
	}
	
	
}
