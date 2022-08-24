package com.example.backendproject.service;

import com.example.backendproject.model.AdminSession;
import com.example.backendproject.repository.AdminSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminSessionRepository adminSessionRepository;
    public List<AdminSession> getAdmin() {
        
        return adminSessionRepository.findAll();
    }


    public void createSession(){

    }
}
