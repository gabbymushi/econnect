package com.example.econnect.controllers;

import com.example.econnect.dtos.Response;
import com.example.econnect.dtos.TalentRequest;
import com.example.econnect.enums.TalentType;
import com.example.econnect.services.ITalentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/talents")
public class TalentController {
    private static final Logger logger = LoggerFactory.getLogger(TalentController.class);
    @Autowired
    ITalentService talentService;

    @GetMapping
    public ResponseEntity<?> getAllTalents(@RequestParam(defaultValue = "ALL") String type) {
        try {
            return ResponseEntity.ok(new Response("Talents retrieved successfully", talentService.getAllTalents(type)));
        } catch (Exception exception) {
            logger.error("Something went wrong {}", exception.getMessage());
            return ResponseEntity.badRequest().body(new Response(exception.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> createTalent(@RequestBody TalentRequest request) {
        try {
            return ResponseEntity.ok(new Response("Talents created successfully", talentService.createTalent(request)));
        } catch (Exception exception) {
            logger.error("Something went wrong {}", exception.getMessage());
            return ResponseEntity.badRequest().body(new Response(exception.getMessage()));
        }
    }
}
