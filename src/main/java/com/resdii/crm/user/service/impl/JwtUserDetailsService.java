package com.resdii.crm.user.service.impl;

import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.LoginRequestDTO;
import com.resdii.crm.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        String passwordEncoded = bcryptEncoder.encode(user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        } else {
            if (bcryptEncoder.matches("042acd3e4652355c873915a09df728d1", user.getPassword())) {
                throw new UsernameNotFoundException(passwordEncoded);
            } else {
                throw new UsernameNotFoundException("Mkhau không chính xác");
            }

        }

    }

    public User save(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
