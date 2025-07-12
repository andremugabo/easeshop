package com.ma.codinglab.shopease.core.user.service;

import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.repository.IUserRepository;
import com.ma.codinglab.shopease.core.util.user.EUserAuthProvider;
import com.ma.codinglab.shopease.core.util.user.EUserRole;
import com.ma.codinglab.shopease.core.util.user.HelperClass;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements IUsersService{

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private  final MailService mailService;

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

        if(theUser.getUserRole() == null){
            theUser.setUserRole(EUserRole.CUSTOMER);
        }

        if(theUser.getAuthProvider() == null){
            theUser.setAuthProvider(EUserAuthProvider.LOCAL);
        }


        theUser.setIsVerified(false);
        theUser.setIsSubscribed(false);
        theUser.setIsPasswordExpired(false);

        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));

        theUser.setOtpCode(HelperClass.hashOtp(HelperClass.generateOtp()));
        theUser.setOtpExpiresAt(LocalDateTime.now().plusMinutes(30));
        theUser.setOtpPurpose("EMAIL_VERIFICATION");
        theUser.setConfirmPassword(null);

        Users savedUser = userRepository.save(theUser);

        //Send email
        String verificationLink = "http://localhost:8080/auth/verify?email=" + savedUser.getEmail() +
                "&code=" + savedUser.getOtpCode();
        mailService.sendVerificationEmail(savedUser.getEmail(),verificationLink);

        return userRepository.save(theUser);
    }

    @Override
    public Users updateUsers(Users theUser) {
        return userRepository.save(theUser);
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

    @Override
    public Optional<Users> findByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }
}
