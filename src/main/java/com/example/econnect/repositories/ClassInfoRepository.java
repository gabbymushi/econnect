package com.example.econnect.repositories;

import com.example.econnect.models.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassInfoRepository extends JpaRepository<ClassInfo, Long> {
    List<ClassInfo> findByLevel(String level);
}
