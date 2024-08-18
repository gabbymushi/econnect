package com.example.econnect.services;

import com.example.econnect.models.Region;
import com.example.econnect.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService implements IRegionService{
    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegions(){
       return regionRepository.findAll();
    }


}
