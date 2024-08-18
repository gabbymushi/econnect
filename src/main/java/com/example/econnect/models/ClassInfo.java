package com.example.econnect.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "class_info")
public class ClassInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotBlank(message = "Name can not be empty.")
    private String name;
    @NotNull
    @NotBlank(message = "Level can not be empty.")
    private String level;

//    @JsonIgnore
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "classInfo", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Student> students;
}
