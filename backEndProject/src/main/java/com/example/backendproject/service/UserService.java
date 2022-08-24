package com.example.backendproject.service;
import com.example.backendproject.dto.RegisterForm;
import com.example.backendproject.model.*;
import com.example.backendproject.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AdminSessionRepository adminSessionRepository;
    private final DoctorSessionRepository doctorSessionRepository;
    private final PatientSessionRepository patientSessionRepository;

    private final AppointmentRepository appointmentRepository;


    public List<User> getUsers() {

        return userRepository.findAll();
    }

        public void register(RegisterForm registerForm) {
            String hashedPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
            registerForm.setPassword(hashedPassword);
            User user = new User(null, registerForm.getUsername(), registerForm.getPassword(), registerForm.getRole());
            User newUser = userRepository.save(user);

            if (registerForm.getRole().equals("Admin")) {
                AdminSession adminSession =new AdminSession(null, registerForm.getUsername(), registerForm.getFullName(), registerForm.getEmail(), newUser.getId());
                adminSessionRepository.save(adminSession);
            } else if (registerForm.getRole().equals("Doctor")) {
                DoctorSession doctorSession = new DoctorSession(null, registerForm.getUsername(), registerForm.getSpeciality(), newUser.getId());
                doctorSessionRepository.save(doctorSession);
            } else {
                PatientSession patientSession = new PatientSession(null,registerForm.getUsername(), newUser.getId());
                patientSessionRepository.save(patientSession);
            }
        }

    public void updateUser(User user, Integer id) {
        User oldUser = userRepository.getById(id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        userRepository.save(oldUser);
    }


    public void deleteUser(Integer id) {
        User myUser = userRepository.getById(id);
        userRepository.delete(myUser);
    }

}
