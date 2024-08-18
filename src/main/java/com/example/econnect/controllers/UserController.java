package com.example.econnect.controllers;

import com.example.econnect.dtos.Response;
import com.example.econnect.dtos.UserDTO;
import com.example.econnect.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseEntity<?> getAllStaff() {
        return ResponseEntity.ok(new Response("Staff retrieved successfully", userService.getAllStaff()));
    }

    @PostMapping
    public ResponseEntity<?> createStaff(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(new Response("Staff created successfully", userService.createStaff(userDTO)));
    }
}
