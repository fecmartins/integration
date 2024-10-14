package com.api.integration.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// interface to handle CRUD operations for the Account entity.
public interface Repository extends JpaRepository<Account, Long> {
    //Select * from account where email = '?'
    Optional<Account> findByEmail(String email);
}
