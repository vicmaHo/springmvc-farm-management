package com.vich.farm_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vich.farm_management.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);
}
