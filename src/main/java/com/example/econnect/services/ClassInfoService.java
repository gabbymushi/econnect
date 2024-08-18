package com.example.econnect.services;

import com.example.econnect.models.ClassInfo;
import com.example.econnect.repositories.ClassInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoService implements IClassInfoService {
    @Autowired
    ClassInfoRepository classInfoRepository;

    @Override
    public List<ClassInfo> getAllClasses(String level) {
        if (level == null) {
            return classInfoRepository.findAll();
        }

        return classInfoRepository.findByLevel(level);
    }
}
