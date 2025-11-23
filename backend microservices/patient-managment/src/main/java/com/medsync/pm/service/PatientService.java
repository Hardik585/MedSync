package com.medsync.pm.service;

import java.util.List;
import java.util.UUID;

import com.medsync.pm.dto.PatientRequestDTO;
import com.medsync.pm.dto.PatientResponseDTO;

public interface PatientService {
  
	public List<PatientResponseDTO> getPatients();
	
	public PatientResponseDTO createPatient(PatientRequestDTO reqDTO);
	
	public PatientResponseDTO updatePatient(UUID id,PatientRequestDTO reqDTO);
	
	public void deletePatient(UUID id);
}
