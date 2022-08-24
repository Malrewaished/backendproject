package com.example.backendproject.repository;
import com.example.backendproject.model.AdminSession;
import com.example.backendproject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
