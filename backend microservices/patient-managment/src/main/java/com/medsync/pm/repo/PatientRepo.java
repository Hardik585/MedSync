package com.medsync.pm.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medsync.pm.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, UUID> {

//	public String findByEmail(String email);
	
	public boolean existsByEmail(String email);
	
	public boolean existsByEmailAndIdNot(String email , UUID id);
}
