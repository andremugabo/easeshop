package com.ma.codinglab.shopease.controller.users;


import com.ma.codinglab.shopease.core.customer.model.Customer;
import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        model.addAttribute("message", "Registration successful. You may now log in.");
        model.addAttribute("user", new Users());
        return "auth/signup";
    }
}
