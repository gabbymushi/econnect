package com.example.econnect.services;

import com.example.econnect.config.JwtUtils;
import com.example.econnect.dtos.SignupRequest;
import com.example.econnect.models.AuthUserDetails;
import com.example.econnect.models.Parent;
import com.example.econnect.models.Student;
import com.example.econnect.models.User;
import com.example.econnect.repositories.ParentRepository;
import com.example.econnect.repositories.StudentRepository;
import com.example.econnect.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements IAuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean isUserAuthenticated(String username, String password) {
        User user = userRepository.findByPhoneNumber(username);

        if (user == null) {
            return false;
        }
        logger.info("admin kafika ndani {}",user.getPassword());
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean isParentAuthenticated(String username, String password) {
        Parent parent = parentRepository.findByPhoneNumber(username);
        if (parent == null) {
            return false;
        }

        return passwordEncoder.matches(password, parent.getPassword());
    }

    @Override
    public AuthUserDetails<?> getAuthenticatedUser(){
        return (AuthUserDetails<?>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public boolean createStudent(SignupRequest signupRequest) {
        Parent parent = getParent(signupRequest);
        parent = parentRepository.save(parent);

        Student student = new Student();
        student.setFirstName(signupRequest.getStudentDetails().getFirstName());
        student.setMiddleName(signupRequest.getStudentDetails().getMiddleName());
        student.setLastName(signupRequest.getStudentDetails().getLastName());
        student.setSex(signupRequest.getStudentDetails().getStudentSex());
        student.setSchoolId(signupRequest.getStudentDetails().getSchoolId());
        student.setClassId(signupRequest.getStudentDetails().getClassId());
        student.setYear(signupRequest.getStudentDetails().getYear());
        student.setParentId(parent.getId());
        studentRepository.save(student);

        return true;
    }

    private Parent getParent(SignupRequest signupRequest) {
        Parent parent = new Parent();
        parent.setFirstName(signupRequest.getParentDetails().getFirstName());
        parent.setMiddleName(signupRequest.getParentDetails().getMiddleName());
        parent.setLastName(signupRequest.getParentDetails().getLastName());
        parent.setSex(signupRequest.getParentDetails().getParentSex());
        parent.setPhoneNumber(signupRequest.getParentDetails().getPhoneNumber());
        parent.setEmail(signupRequest.getParentDetails().getEmail());
        parent.setWardId(signupRequest.getParentDetails().getWardId());
        parent.setPassword(passwordEncoder.encode(signupRequest.getParentDetails().getLastName().toUpperCase()));
        parent.setRole("PARENT");
        return parent;
    }
}
