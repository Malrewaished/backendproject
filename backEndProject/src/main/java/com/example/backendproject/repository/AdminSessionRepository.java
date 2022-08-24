package com.example.backendproject.repository;
import com.example.backendproject.model.AdminSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminSessionRepository extends JpaRepository<AdminSession, Integer> {
}
