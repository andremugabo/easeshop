package com.ma.codinglab.shopease.controller.users;


import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUsersService usersService;

    @GetMapping("/userPage")
    public String getUserPage(Model model){
        List<Users> users = usersService.findAllUsers();
        model.addAttribute("user", users);
        return "admin/usersPage";
    }



}
