package com.ma.codinglab.shopease.controller.customer;

import com.ma.codinglab.shopease.core.customer.model.Customer;
import com.ma.codinglab.shopease.core.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping("/signup")
    public String showRegistrationFrom(Model model){
        model.addAttribute("customer", new Customer());
        return "auth/signup";
    }


    @ModelAttribute("customer")
    public Customer customerModel() {
        return new Customer();
    }


    @PostMapping("/signup")
    public String registerCustomer(@ModelAttribute("customer") Customer theCustomer, Model model) {
        System.out.println("POST /customer/register called with customer: " + theCustomer);
        if (theCustomer.getEmail() == null || theCustomer.getEmail().isBlank()) {
            model.addAttribute("error", "Registration failed! Email is required.");
            model.addAttribute("customer", theCustomer);
            return "auth/signup";
        }

        if (theCustomer.getPassword() == null || theCustomer.getConfirmPassword() == null ||
                !theCustomer.getPassword().equals(theCustomer.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match!");
            model.addAttribute("customer", theCustomer);
            return "auth/signup";
        }

        customerService.registerCustomer(theCustomer);
        model.addAttribute("message", "Customer registered successfully! You can log in now.");
        model.addAttribute("customer", new Customer());
        return "auth/signup";
    }

    @GetMapping("/customerPage")
    public String customerPage(Model model){
        List<Customer> customers = customerService.findCustomersByActive(Boolean.TRUE);
        model.addAttribute("customers", customers);
        return "admin/customerPage";
    }
}
