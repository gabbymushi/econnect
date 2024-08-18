package com.example.econnect.services;

import com.example.econnect.models.AuthUserDetails;
import com.example.econnect.models.Parent;
import com.example.econnect.models.User;
import com.example.econnect.repositories.ParentRepository;
import com.example.econnect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNumber(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new AuthUserDetails<>(user);
    }

    public UserDetails loadUserByPhoneNumber(String username) throws UsernameNotFoundException {
        Parent parent = parentRepository.findByPhoneNumber(username);

        if (parent == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new AuthUserDetails<>(parent);
    }
}
