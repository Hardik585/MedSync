package com.medsync.pm.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

	@NotBlank
	@Size(max=100 ,message="")
	private String name;
	
	@NotBlank(message="email can't be null")
	@Email(message="email should be valid")
	private String email;
	
	@NotBlank(message="address is required")
	private String address;
	
	@NotBlank(message="date of birth is required")
	private LocalDate dateOfBirth;
	
	@NotBlank(message=" registerd date is required")
	private LocalDate registeredDate;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	
	
}
