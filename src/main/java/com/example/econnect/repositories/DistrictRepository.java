package com.example.econnect.repositories;

import com.example.econnect.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
    District findByName(String name);
}
