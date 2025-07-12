package com.ma.codinglab.shopease.core.user.service;

import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> usersOptional;
        if (username.contains("@")) {
            usersOptional = userRepository.findByEmail(username);
        } else {
            usersOptional = userRepository.findByPhone(username);
        }

        Users theUser = usersOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!Boolean.TRUE.equals(theUser.getIsVerified())) {
            throw new RuntimeException("Please verify your email first.");
        }

        return new org.springframework.security.core.userdetails.User(
                theUser.getEmail(),
                theUser.getPassword(),
                Set.of(new SimpleGrantedAuthority("ROLE_" + theUser.getUserRole().name()))
        );
    }
}
