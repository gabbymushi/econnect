package com.example.econnect.controllers;

import com.example.econnect.config.JwtUtils;
import com.example.econnect.dtos.LoginRequest;
import com.example.econnect.dtos.LoginResponse;
import com.example.econnect.dtos.Response;
import com.example.econnect.dtos.SignupRequest;
import com.example.econnect.models.AuthUserDetails;
import com.example.econnect.models.Parent;
import com.example.econnect.models.User;
import com.example.econnect.repositories.ParentRepository;
import com.example.econnect.repositories.UserRepository;
import com.example.econnect.services.AuthService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    AuthService authService;
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        try {
            authService.createStudent(signupRequest);
            return ResponseEntity.ok(new Response("Student created successfully"));
        } catch (Exception exception) {
            logger.error("Registration error {}:", exception.getMessage());
            return ResponseEntity.badRequest().body(new Response("Registration process failed try again later or contact the admin"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        if (!authService.isParentAuthenticated(loginRequest.getUsername(), loginRequest.getPassword())) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.UNAUTHORIZED);
        }

        Parent parent = parentRepository.findByPhoneNumber(loginRequest.getUsername());
        String jwtToken = jwtUtils.generateToken(new AuthUserDetails<>(parent));

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(parent.getPhoneNumber());
        loginResponse.setJwtToken(jwtToken);
        loginResponse.setRole(parent.getRole());

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<?> authenticateStaff(@Valid @RequestBody LoginRequest loginRequest) {
        logger.info("admin kafika");
        if (!authService.isUserAuthenticated(loginRequest.getUsername(), loginRequest.getPassword())) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.UNAUTHORIZED);
        }
        logger.info("admin kafika");
        User user = userRepository.findByPhoneNumber(loginRequest.getUsername());
        String jwtToken = jwtUtils.generateToken(new AuthUserDetails<>(user));

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getPhoneNumber());
        loginResponse.setJwtToken(jwtToken);
        loginResponse.setRole(user.getRole());

        return ResponseEntity.ok(loginResponse);
    }
}
