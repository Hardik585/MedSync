package com.medsync.pm.service;

import java.util.List;

import com.medsync.pm.dto.PatientRequestDTO;
import com.medsync.pm.dto.PatientResponseDTO;

public interface PatientService {
  
	public List<PatientResponseDTO> getPatients();
	
	public PatientResponseDTO createPatient(PatientRequestDTO dto);
}
