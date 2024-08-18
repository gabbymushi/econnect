package com.example.econnect.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "regions")
public class Region implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name can not be empty.")
    private String name;

   // @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "region",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<District> districts;
}
