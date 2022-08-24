package com.example.backendproject.repository;
import com.example.backendproject.model.PatientSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientSessionRepository extends JpaRepository<PatientSession, Integer> {

    PatientSession getPatientSessionById(Integer patient_Id);
}
