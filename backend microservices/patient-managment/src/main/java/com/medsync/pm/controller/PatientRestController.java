package com.medsync.pm.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medsync.pm.dto.PatientRequestDTO;
import com.medsync.pm.dto.PatientResponseDTO;
import com.medsync.pm.dto.validators.CreatePatientValidationGroup;
import com.medsync.pm.service.PatientServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("/patient")
@Tag(name="Pateint API", description = "API for managing Patients")
public class PatientRestController {

	private final PatientServiceImpl service;

	public PatientRestController(PatientServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/greet")
	@Operation(description = "used for testing")
	public String greet() {
		return "wlm to medsync project";
	}

	@GetMapping("/allpatients")
	@Operation(description = "used for get all pateint record")
	public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
		List<PatientResponseDTO> patients = service.getPatients();
		return new ResponseEntity<List<PatientResponseDTO>>(patients, HttpStatus.OK);
	}

	@PostMapping("/create")
	@Operation(description = "used for create new patient record")
	public ResponseEntity<PatientResponseDTO> createPatient(
			@Validated({ Default.class, CreatePatientValidationGroup.class }) @RequestBody PatientRequestDTO reqDTO) {
		PatientResponseDTO patient = service.createPatient(reqDTO);
		return new ResponseEntity<PatientResponseDTO>(patient, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	@Operation(description = "used for update patient record")
	public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
			@Validated({ Default.class }) @RequestBody PatientRequestDTO reqDTO) {
		PatientResponseDTO patient = service.updatePatient(id, reqDTO);
		return new ResponseEntity<PatientResponseDTO>(patient, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	@Operation(description = "used for delete a patient record")
	public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
		service.deletePatient(id);
		return ResponseEntity.noContent().build();
	}
}
