package com.medsync.pm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.pm.dto.PatientResponseDTO;
import com.medsync.pm.service.PatientServiceImpl;

@RestController
@RequestMapping("/patient")
public class PatientRestController {
	
	
	private final PatientServiceImpl service;
	
	
	public PatientRestController(PatientServiceImpl service) {
		this.service=service;
	}

	@GetMapping("/greet")
	public String greet() {
		return "wlm to medsync project";
	}
	
	@GetMapping("/allpatients")
	public ResponseEntity<List<PatientResponseDTO>> getAllPatients(){
		    List<PatientResponseDTO> patients = service.getPatients();
		    return new ResponseEntity<List<PatientResponseDTO>>(patients, HttpStatus.OK);
	}
}
