package com.example.backendproject.controller;

import com.example.backendproject.service.DoctorService;
import com.example.backendproject.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity getPatients() {

        return ResponseEntity.status(200).body(patientService.getPatients());
    }

}