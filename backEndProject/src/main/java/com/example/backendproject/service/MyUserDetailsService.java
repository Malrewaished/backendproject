package com.example.backendproject.service;
import com.example.backendproject.model.User;
import com.example.backendproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;


        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findUserByUsername(username)
                    .orElseThrow(()-> new UsernameNotFoundException("Invalid username or password"));
            return user;
        }
    }
