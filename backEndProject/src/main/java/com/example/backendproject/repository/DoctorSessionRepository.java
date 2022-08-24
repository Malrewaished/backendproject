package com.example.backendproject.repository;
import com.example.backendproject.model.DoctorSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorSessionRepository extends JpaRepository<DoctorSession, Integer> {
}