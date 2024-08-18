package com.example.econnect.controllers;

import com.example.econnect.dtos.Response;
import com.example.econnect.services.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/regions")
public class RegionController {
    @Autowired
    IRegionService regionService;

    @GetMapping
    public ResponseEntity<Object> getRegions() {
        return ResponseEntity.ok(new Response("Regions retrieved successfully.", regionService.getAllRegions()));
    }
}
