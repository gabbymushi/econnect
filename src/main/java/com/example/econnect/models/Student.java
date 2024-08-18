package com.example.econnect.models;

import com.example.econnect.enums.Sex;
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
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    @Column(name = "middle_name")
    private String middleName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    //@Column(name = "phone_number")
   // @Size(min = 12, max = 12, message = "Phone Number size must be 12 digits")
//    @NotBlank(message = "Contact Phone Number can not be null or empty")
//    private String phoneNumber;
   // private String email;
    //private String password;
    @Column(name = "parent_id")
    private long parentId;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column(name = "school_id")
    private long schoolId;
    @Column(name = "class_id")
    private long classId;
    private long year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id",referencedColumnName = "id",insertable = false,updatable = false)
    private School school;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Parent parent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id",referencedColumnName = "id",insertable = false,updatable = false)
    private ClassInfo classInfo;
}
