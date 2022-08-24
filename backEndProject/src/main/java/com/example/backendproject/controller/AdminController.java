package com.example.backendproject.controller;

import com.example.backendproject.dto.Api;
import com.example.backendproject.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/admin")
    public ResponseEntity getAdmin() {
        return ResponseEntity.status(200).body(adminService.getAdmin());
    }


    @GetMapping("/login")
    public ResponseEntity logInAdmin() {
        return ResponseEntity.status(200).body(new Api("Hey admin", 201));
    }


}
