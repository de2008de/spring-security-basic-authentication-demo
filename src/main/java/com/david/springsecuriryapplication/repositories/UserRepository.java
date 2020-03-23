package com.david.springsecuriryapplication.repositories;

import javax.transaction.Transactional;

import com.david.springsecuriryapplication.authentication.UserCredentials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserCredentials, String> {

    UserCredentials findByUsername(String username);

}
