package com.example.econnect.repositories;

import com.example.econnect.models.Parent;
import com.example.econnect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent,Long> {
    Parent findByPhoneNumber(String username);
}
