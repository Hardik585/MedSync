package com.medsync.pm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medsync.pm.dto.PatientRequestDTO;
import com.medsync.pm.dto.PatientResponseDTO;
import com.medsync.pm.entity.Patient;
import com.medsync.pm.mapper.PatientMapper;
import com.medsync.pm.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepo patientRepo;

	public PatientServiceImpl(PatientRepo patientRepo) {
		this.patientRepo = patientRepo;
	}

	@Override
	public List<PatientResponseDTO> getPatients() {
		List<Patient> allPatient = patientRepo.findAll();
		List<PatientResponseDTO> list = allPatient.stream().map((patient) -> PatientMapper.toDTO(patient)).toList();
		return list;
	}

	@Override
	public PatientResponseDTO createPatient(PatientRequestDTO reqDTO) {
		Patient newPatient = PatientMapper.toEntity(reqDTO);
		Patient patient = patientRepo.save(newPatient);
		return PatientMapper.toDTO(patient);
	}

}
