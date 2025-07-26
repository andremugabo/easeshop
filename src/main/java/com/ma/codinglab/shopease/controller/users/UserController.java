package com.ma.codinglab.shopease.controller.users;


import com.ma.codinglab.shopease.core.customer.model.Customer;
import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final IUsersService usersService;

    @GetMapping("/signup")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String registerCustomer(@ModelAttribute("user") Users theUser, Model model) {
        if (theUser.getEmail() == null || theUser.getEmail().isBlank()) {
            model.addAttribute("error", "Registration failed! Email is required.");
            model.addAttribute("user", theUser);
            return "auth/signup";
        }

        if (usersService.existsByEmail(theUser.getEmail())) {
            model.addAttribute("error", "An account with this email already exists.");
            model.addAttribute("user",theUser);
            return "auth/signup";
        }

        if (theUser.getPassword() == null || theUser.getConfirmPassword() == null ||
                !theUser.getPassword().equals(theUser.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            model.addAttribute("user",theUser);
            return "auth/signup";
        }

        usersService.registerUser(theUser);
        model.addAttribute("message", "Registration successful. Verify your account before Login.");
        model.addAttribute("user", new Users());
        return "auth/signup";
    }

    @GetMapping("/verify")
    public String verifyUser(@RequestParam("email") String email,
                             @RequestParam("code") String code, Model model) {
        Optional<Users> userOpt = usersService.findByEmail(email);
        if (userOpt.isPresent()) {
            Users user = userOpt.get();

            // Safely check if OTP code and expiry exist
            if (user.getOtpCode() != null && user.getOtpExpiresAt() != null) {
                if (user.getOtpCode().equals(code) && user.getOtpExpiresAt().isAfter(LocalDateTime.now())) {
                    user.setIsVerified(true);
                    user.setOtpCode(null);
                    user.setOtpExpiresAt(null);
                    user.setOtpPurpose(null);
                    usersService.updateUsers(user);
                    model.addAttribute("message", "Email verified! You can now log in.");
                    return "auth/login";
                }
            }
        }

        model.addAttribute("error", "Invalid or expired verification link.");
        return "auth/signup";
    }







}
