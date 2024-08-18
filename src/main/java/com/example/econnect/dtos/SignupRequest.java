package com.example.econnect.dtos;

import com.example.econnect.enums.Sex;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {
    @Valid
    private Student studentDetails;
    @Valid
    private Parent parentDetails;

    @Data
    public static class Student {
        @NotBlank(message = "First name can not be null or empty")
        private String firstName;
        @NotBlank(message = "Middle name can not be null or empty")
        private String middleName;
        @NotBlank(message = "Last name can not be null or empty")
        private String lastName;
//        @NotBlank(message = "Contact Phone Number can not be null or empty")
//        private String phoneNumber;
        // private String email;
        //private String password;
        @NotNull(message = "Sex can not be null or empty")
        private Sex studentSex;
        @NotNull(message = "School Id can not be null or empty")
        private long schoolId;
        @NotNull(message = "Class Id can not be null or empty")
        private long classId;
        @NotNull(message = "Year can not be null or empty")
        private long year;
    }

    @Data
    public static class Parent {
        @NotBlank(message = "First name can not be null or empty")
        private String firstName;
        @NotBlank(message = "Middle name can not be null or empty")
        private String middleName;
        @NotBlank(message = "Last name can not be null or empty")
        private String lastName;
        @NotNull(message = "Sex can not be null or empty")
        private Sex parentSex;
        @Size(min = 12, max = 12, message = "Phone Number size must be 12 digits")
        @NotBlank(message = "Phone Number can not be null or empty")
        private String phoneNumber;
        private String email;
        // private String role;
        // private String password;
        @NotNull(message = "Ward Id can not be null or empty")
        private long wardId;
    }
}
