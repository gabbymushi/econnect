package com.example.econnect.services;

import com.example.econnect.models.School;

import java.util.List;

public interface ISchoolService {
    List<School> getAllSchools();
    School createSchool(School school);
}
