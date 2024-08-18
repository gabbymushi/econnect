package com.example.econnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "First name can not be null or empty")
    private String firstName;
    @NotBlank(message = "Middle name can not be null or empty")
    private String middleName;
    @NotBlank(message = "Last name can not be null or empty")
    private String lastName;
    @Size(min = 12, max = 12, message = "Phone Number size must be 12 digits")
    @NotBlank(message = "Phone Number can not be null or empty")
    private String phoneNumber;
    @NotBlank(message = "Email can not be null or empty")
    private String email;
    //    @NotBlank(message = "Password can not be null or empty")
    @NotBlank(message = "Role can not be null or empty")
    private String role;
    @NotBlank(message = "Sex can not be null or empty")
    private String sex;
//    private String password;
}
