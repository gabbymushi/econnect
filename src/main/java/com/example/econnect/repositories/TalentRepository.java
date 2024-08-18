package com.example.econnect.repositories;

import com.example.econnect.enums.TalentType;
import com.example.econnect.models.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
    List<Talent> findByType(TalentType type);
}
