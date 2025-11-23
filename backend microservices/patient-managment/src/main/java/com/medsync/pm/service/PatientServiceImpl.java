package com.medsync.pm.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.medsync.pm.dto.PatientRequestDTO;
import com.medsync.pm.dto.PatientResponseDTO;
import com.medsync.pm.entity.Patient;
import com.medsync.pm.exception.EmailAlreadyExist;
import com.medsync.pm.exception.PatientDoesNotExist;
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
		if (patientRepo.existsByEmail(reqDTO.getEmail())) {
			throw new EmailAlreadyExist("Email is already exit with a patient");
		}
		Patient newPatient = PatientMapper.toEntity(reqDTO);
		Patient patient = patientRepo.save(newPatient);
		return PatientMapper.toDTO(patient);
	}

	@Override
	public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO reqDTO) {
		Patient patient = patientRepo.findById(id)
				.orElseThrow(() -> new PatientDoesNotExist("Patient with this uuid is not exist"));
		if (patientRepo.existsByEmailAndIdNot(reqDTO.getEmail() , id)) {
			throw new EmailAlreadyExist("Email is alredy taken");
		}

		patient.setName(reqDTO.getName());
		patient.setEmail(reqDTO.getEmail());
		patient.setAddress(reqDTO.getAddress());
		patient.setDateOfBirth(LocalDate.parse(reqDTO.getDateOfBirth()));

		Patient updatePatient = patientRepo.save(patient);
		return PatientMapper.toDTO(updatePatient);
	}
	
	@Override
	public void deletePatient(UUID id) {
		patientRepo.deleteById(id);
		return;
	}

}
