package com.example.backendproject.controller;

import com.example.backendproject.dto.Api;
import com.example.backendproject.service.AdminService;
import com.example.backendproject.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/app")
    public ResponseEntity getAppointments() {
        return ResponseEntity.status(201).body(appointmentService.getAppointment());
    }


    @PostMapping("/app")
    public ResponseEntity createAppointment(@RequestParam @Valid Integer patient_Id) {
        appointmentService.createAppointment(patient_Id);
        return ResponseEntity.status(201).body(new Api("Appointment created ", 201));
    }
}

