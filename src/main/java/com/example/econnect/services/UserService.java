package com.example.econnect.services;

import com.example.econnect.dtos.UserDTO;
import com.example.econnect.enums.Sex;
import com.example.econnect.models.User;
import com.example.econnect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllStaff(){
        return userRepository.findAll();
    }

    @Override
    public User createStaff(UserDTO userDTO) {
        User user=new User();
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setRole(userDTO.getRole());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setSex(Sex.valueOf(userDTO.getSex()));
        user.setPassword(passwordEncoder.encode(userDTO.getLastName().toUpperCase()));
        return userRepository.save(user);
    }
}
