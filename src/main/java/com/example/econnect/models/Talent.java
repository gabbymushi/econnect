package com.example.econnect.models;

import com.example.econnect.enums.Sex;
import com.example.econnect.enums.TalentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "talents")
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name can not be empty.")
    @NotNull
    private String name;
    private String description;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TalentType type;
}
