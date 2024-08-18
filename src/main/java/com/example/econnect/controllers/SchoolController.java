package com.example.econnect.controllers;

import com.example.econnect.dtos.Response;
import com.example.econnect.services.ISchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
    @Autowired
    ISchoolService schoolService;

    @GetMapping
    public ResponseEntity<?> getSchools() {
        return ResponseEntity.ok(new Response("Schools retrieved successfully", schoolService.getAllSchools()));
    }
}
