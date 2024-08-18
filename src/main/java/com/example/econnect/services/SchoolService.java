package com.example.econnect.services;

import com.example.econnect.models.School;
import com.example.econnect.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService implements ISchoolService{
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    @Override
    public School createSchool(School school){
        return schoolRepository.save(school);
    }
}
