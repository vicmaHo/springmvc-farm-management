package com.vich.farm_management.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vich.farm_management.model.AppUser;
import com.vich.farm_management.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * Custom implementation of UserDetailsService interface
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    
    /**
     * Load user data by username and return a UserDetails object (Spring User).
     *
     * @param username the username of the user to load
     * @return a UserDetails object containing the user's data
     * @throws UsernameNotFoundException if the user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // We search our database user by username and transform it into a Spring User for spring security
        AppUser appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado."));

        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles("USER")
                .build();
    }

}
