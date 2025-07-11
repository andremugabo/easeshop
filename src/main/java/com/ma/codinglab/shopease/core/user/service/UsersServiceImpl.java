package com.ma.codinglab.shopease.core.user.service;

import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.repository.IUserRepository;
import com.ma.codinglab.shopease.core.util.user.EUserAuthProvider;
import com.ma.codinglab.shopease.core.util.user.EUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements IUsersService{

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users registerUser(Users theUser) {
        if(theUser.getEmail() == null || theUser.getPassword() == null
                || theUser.getFirstname() == null || theUser.getLastname() == null){
            throw new IllegalArgumentException("Missing required Field ");
        }

        if(userRepository.existsByEmail(theUser.getEmail())){
            throw new IllegalArgumentException("Email is already in use");
        }

        if(userRepository.existsByPhone(theUser.getPhone())){
            throw new IllegalArgumentException("Phone number is already in use");
        }

        if(theUser.getUserRole() == null || theUser.getUserRole().isEmpty()){
            theUser.setUserRole(Set.of(EUserRole.CUSTOMER));
        }

        if(theUser.getAuthProvider() == null){
            theUser.setAuthProvider(EUserAuthProvider.LOCAL);
        }


        theUser.setIsVerified(false);
        theUser.setIsSubscribed(false);
        theUser.setIsPasswordExpired(false);

        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));

        theUser.setConfirmPassword(null);


        return userRepository.save(theUser);
    }

    @Override
    public Users updateUsers(Users theUser) {
        return null;
    }

    @Override
    public Users deleteUsers(Users theUser) {
        return null;
    }

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Users> findUserByActive(Boolean active) {
        return userRepository.findByActive(Boolean.TRUE);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
