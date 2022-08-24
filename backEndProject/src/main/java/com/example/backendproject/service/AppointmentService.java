package com.example.backendproject.service;

import com.example.backendproject.dto.Api;
import com.example.backendproject.exception.ApiException;
import com.example.backendproject.model.AdminSession;
import com.example.backendproject.model.Appointment;
import com.example.backendproject.model.PatientSession;
import com.example.backendproject.repository.AdminSessionRepository;
import com.example.backendproject.repository.AppointmentRepository;
import com.example.backendproject.repository.PatientSessionRepository;
import com.example.backendproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientSessionRepository patientSessionRepository;
    public List<Appointment> getAppointment() {

        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Integer patient_Id) {
        PatientSession currPatient = patientSessionRepository.getPatientSessionById(patient_Id);
        if (currPatient == null) {
            throw new ApiException("Invalid input");
        } else {
            Appointment appointment = new Appointment();
            appointment.setPatient_Name(currPatient.getUsername());
            appointment.setPatient_Id(patient_Id);
            appointmentRepository.save(appointment);
            return appointment;
        }
    }
}
