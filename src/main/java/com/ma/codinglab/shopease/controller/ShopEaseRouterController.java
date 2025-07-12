package com.ma.codinglab.shopease.controller;

import com.ma.codinglab.shopease.core.customer.model.Customer;
import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.service.IUsersService;
import com.ma.codinglab.shopease.core.util.user.EUserRole;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ShopEaseRouterController {

    private final IUsersService usersService;

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
    public String getLoginForm(Model model) {
        model.addAttribute("user", new Users());
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

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        return "admin/dashboardPage";
    }

    @ModelAttribute("user")
    public Customer customerModel() {
        return new Customer();
    }

    @GetMapping("/signup")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());
        return "auth/signup";
    }
}
