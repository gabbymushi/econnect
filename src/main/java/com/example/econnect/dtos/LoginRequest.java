package com.example.econnect.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "Username can not be empty")
    private String username;
    @NotBlank(message = "Password can not be empty")
    private String password;
}
