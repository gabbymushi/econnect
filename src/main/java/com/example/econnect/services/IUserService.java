package com.example.econnect.services;

import com.example.econnect.dtos.UserDTO;
import com.example.econnect.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAllStaff();
    User createStaff(UserDTO userDTO);
}
