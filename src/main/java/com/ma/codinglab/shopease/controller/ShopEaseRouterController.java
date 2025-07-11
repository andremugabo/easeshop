package com.ma.codinglab.shopease.controller;

import com.ma.codinglab.shopease.core.customer.model.Customer;
import com.ma.codinglab.shopease.core.user.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ShopEaseRouterController {

    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/categories")
    public String categories() {
        return "categories/index";
    }

    @GetMapping("/products")
    public String products() {
        return "products/index";
    }

    @GetMapping("/sales")
    public String sales() {
        return "sales/index";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("loginError", true);
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "You have been logged out successfully.");
        }
        return "auth/login";
    }


    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "auth/forgot-password";
    }

    @GetMapping("/resetPassword")
    public String resetPassword() {
        return "auth/reset-password";
    }

    @GetMapping("/verifyOtp")
    public String verifyOtp() {
        return "auth/verify-otp";
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        return "admin/dashboardPage";
    }

    @ModelAttribute("user")
    public Customer customerModel() {
        return new Customer();
    }

    @GetMapping("/signup")
    public String showRegistrationFrom(Model model){
        model.addAttribute("user", new Users());
        return "auth/signup";
    }
}
