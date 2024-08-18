package com.example.econnect.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "student_talents",indexes = {@Index(name = "idx_student_id_talent_id",columnList="student_id,talent_id")})
public class StudentTalent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long studentId;
    private long talentId;
}
