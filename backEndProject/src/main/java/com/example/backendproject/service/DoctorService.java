package com.example.backendproject.service;
import com.example.backendproject.model.DoctorSession;
import com.example.backendproject.repository.DoctorSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorSessionRepository doctorSessionRepository;
    public List<DoctorSession> getDoctors() {
        return doctorSessionRepository.findAll();
    }


    public void updateUser(DoctorSession doctorSession, Integer id) {
        DoctorSession oldUser = doctorSessionRepository.getById(id);
        oldUser.setUsername(doctorSession.getUsername());
        oldUser.setSpeciality(doctorSession.getSpeciality());
        doctorSessionRepository.save(oldUser);
    }
    }
