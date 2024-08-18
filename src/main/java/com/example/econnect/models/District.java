package com.example.econnect.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "districts")
public class District implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name can not be empty.")
    private String name;
    @Column(name = "region_id")
    private long regionId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Region region;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "district",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<School> schools;

   // @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "district",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ward> wards;
}
