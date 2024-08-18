package com.example.econnect.repositories;

import com.example.econnect.models.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends JpaRepository<Ward,Long> {
    Ward findByName(String name);
}
