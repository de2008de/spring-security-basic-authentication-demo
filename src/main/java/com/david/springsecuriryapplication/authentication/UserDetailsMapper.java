package com.david.springsecuriryapplication.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    UserDetails toUserDetails(UserCredentials userCredentials) {

        String[] roles = new String[userCredentials.getRoles().size()];

        return User.withUsername(userCredentials.getUsername())
            .password(userCredentials.getPassword())
            .roles(userCredentials.getRoles().toArray(roles))
            .build();

    }

}
