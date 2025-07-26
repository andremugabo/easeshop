package com.ma.codinglab.shopease.core.user.service;

import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Custom UserDetailsService implementation to load user data from database
 * using either email or phone as username.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Authenticating user: {}", username);

        if (username == null || username.trim().isEmpty()) {
            log.warn("Empty username provided");
            throw new UsernameNotFoundException("Username cannot be empty");
        }

        Optional<Users> userOptional = username.contains("@")
                ? userRepository.findByEmail(username)
                : userRepository.findByPhone(username);

        Users user = userOptional.orElseThrow(() -> {
            log.warn("User not found with identifier: {}", username);
            return new UsernameNotFoundException("User not found with email or phone: " + username);
        });

        if (Boolean.FALSE.equals(user.getIsVerified())) {
            log.warn("User {} has not verified their email.", username);
            throw new DisabledException("Please verify your email before logging in.");
        }

        String principal = username.contains("@") ? user.getEmail() : user.getPhone();

        log.info("User {} authenticated successfully with role: {}", principal, user.getUserRole().name());

        return new org.springframework.security.core.userdetails.User(
                principal,
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getUserRole().name()))
        );
    }
}
