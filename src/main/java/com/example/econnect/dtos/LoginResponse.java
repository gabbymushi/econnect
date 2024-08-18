package com.example.econnect.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginResponse {
    private String jwtToken;
    private String username;
    private String role;
}
