package com.example.econnect.services;

import com.example.econnect.dtos.SignupRequest;
import com.example.econnect.models.AuthUserDetails;

public interface IAuthService {
    boolean isUserAuthenticated(String username, String password);

    boolean isParentAuthenticated(String username, String password);

    AuthUserDetails<?> getAuthenticatedUser();

    boolean createStudent(SignupRequest signupRequest);
}
