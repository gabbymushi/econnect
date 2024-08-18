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
@Table(name = "wards")
public class Ward implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name can not be empty.")
    private String name;
    @Column(name = "district_id")
    private long districtId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id",referencedColumnName = "id",insertable=false, updatable=false)
    private District district;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "ward",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Parent> parents;
}
