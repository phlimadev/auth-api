package com.example.auth_api.controllers;

import com.example.auth_api.dtos.LoginDTO;
import com.example.auth_api.dtos.RegisterDTO;
import com.example.auth_api.dtos.TokenDTO;
import com.example.auth_api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginDTO data) {
        TokenDTO token = userService.login(data);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        userService.register(data);
        return ResponseEntity.ok().build();
    }
}
