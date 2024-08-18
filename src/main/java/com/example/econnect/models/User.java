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
@Table(name = "users")
public class User implements IUser,Serializable {
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
    @NotNull
    @Column(unique = true)
    private String email;
    private String role;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @JsonIgnore
    private String password;
}
