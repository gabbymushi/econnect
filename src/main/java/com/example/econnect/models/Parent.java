package com.example.econnect.models;

import com.example.econnect.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "parents")
public class Parent implements IUser,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "middle_name")
    private String middleName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Column(name = "phone_number",unique = true)
    @Size(min = 12, max = 12, message = "Phone Number size must be 12 digits")
    @NotBlank(message = "Phone Number can not be null or empty")
    private String phoneNumber;
    private String email;
    private String role;
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column(name = "ward_id")
    private long wardId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ward_id",referencedColumnName = "id",updatable = false,insertable = false)
    private Ward ward;
}
