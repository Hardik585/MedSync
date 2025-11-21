package com.medsync.pm.mapper;

import com.medsync.pm.dto.PatientResponseDTO;
import com.medsync.pm.entity.Patient;

public class PatientMapper {

	public static PatientResponseDTO toDTO(Patient patient) {
		PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
		patientResponseDTO.setId(patient.getId());
		patientResponseDTO.setName(patient.getName());
		patientResponseDTO.setEmail(patient.getEmail());
		patientResponseDTO.setDateOfBirth(patient.getDateOfBirth());
		patientResponseDTO.setRegisteredDate(patient.getRegisteredDate());
		return patientResponseDTO;
	}
}
