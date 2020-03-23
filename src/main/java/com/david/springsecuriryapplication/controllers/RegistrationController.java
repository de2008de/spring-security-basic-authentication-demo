package com.david.springsecuriryapplication.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.david.springsecuriryapplication.authentication.UserCredentials;
import com.david.springsecuriryapplication.entities.UserCredentialDto;
import com.david.springsecuriryapplication.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping
    public Map<String, String> register(@RequestBody UserCredentialDto userCredentialDto) {

        Map<String, String> result = new HashMap<>();
        UserCredentials user = new UserCredentials();
        Set<String> roles = new HashSet<>();
        roles.add("USER");

        user.setEnabled(true);
        user.setUsername(userCredentialDto.getUsername());
        user.setPassword(encoder.encode(userCredentialDto.getPassword()));
        user.setRoles(roles);

        userRepository.save(user);

        result.put("message", "success");

        return result;
    }

}
