package com.example.econnect.services;

import com.example.econnect.models.ClassInfo;

import java.util.List;

public interface IClassInfoService {
    List<ClassInfo> getAllClasses(String level);
}
