package com.example.econnect.controllers;

import com.example.econnect.dtos.Response;
import com.example.econnect.models.Parent;
import com.example.econnect.services.IAuthService;
import com.example.econnect.services.IClassInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/classes")
public class ClassInfoController {
    @Autowired
    IClassInfoService classInfoService;
    @Autowired
    IAuthService authService;

    @GetMapping
    public ResponseEntity<?> getAllClasses(@RequestParam(required = false) String level) {
        log.info(level);
       // log.info("YEEEEEW {}",((Parent) authService.getAuthenticatedUser().getUser()).getFirstName());
        return ResponseEntity.ok(new Response("Classes retrieved successfully.", classInfoService.getAllClasses(level)));
    }
}
