package com.example.backendproject.service;

import com.example.backendproject.model.DoctorSession;
import com.example.backendproject.model.PatientSession;
import com.example.backendproject.repository.DoctorSessionRepository;
import com.example.backendproject.repository.PatientSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientSessionRepository patientSessionRepository;

    public List<PatientSession> getPatients() {
        return patientSessionRepository.findAll();
    }



}