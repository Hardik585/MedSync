package com.medsync.pm.mapper;

import java.time.LocalDate;

import com.medsync.pm.dto.PatientRequestDTO;
import com.medsync.pm.dto.PatientResponseDTO;
import com.medsync.pm.entity.Patient;

public class PatientMapper {

	public static PatientResponseDTO toDTO(Patient patient) {
		PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
		patientResponseDTO.setId(patient.getId());
		patientResponseDTO.setName(patient.getName());
		patientResponseDTO.setEmail(patient.getEmail());
		patientResponseDTO.setAddress(patient.getAddress());
		patientResponseDTO.setDateOfBirth(patient.getDateOfBirth());
		patientResponseDTO.setRegisteredDate(patient.getRegisteredDate());
		return patientResponseDTO;
	}

	public static Patient toEntity(PatientRequestDTO reqDTO) {
		Patient patient = new Patient();
		patient.setName(reqDTO.getName());
		patient.setEmail(reqDTO.getEmail());
		patient.setAddress(reqDTO.getAddress());
		patient.setDateOfBirth(LocalDate.parse(reqDTO.getDateOfBirth()));
		patient.setRegisterdDate(LocalDate.parse(reqDTO.getRegisteredDate()));
		return patient;
	}
}
