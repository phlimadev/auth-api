package com.example.auth_api.services;

import com.example.auth_api.dtos.LoginDTO;
import com.example.auth_api.dtos.RegisterDTO;
import com.example.auth_api.entities.User;
import com.example.auth_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    public void login(LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authenticationManager.authenticate(usernamePassword);
    }

    public void register(RegisterDTO data) {
        if (userRepository.findByLogin(data.login()) != null) {
            throw new RuntimeException("This user already exists.");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        userRepository.save(newUser);
    }
}
