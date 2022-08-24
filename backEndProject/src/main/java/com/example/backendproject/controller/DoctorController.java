package com.example.backendproject.controller;

import com.example.backendproject.dto.Api;
import com.example.backendproject.model.DoctorSession;
import com.example.backendproject.model.User;
import com.example.backendproject.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity getDoctors() {

        return ResponseEntity.status(200).body(doctorService.getDoctors());
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<Api> updateUser(@RequestBody @Valid DoctorSession doctorSession, @PathVariable Integer id){
        doctorService.updateUser(doctorSession, id);
        return ResponseEntity.status(201).body(new Api("Doctor updated",201));
    }

}
