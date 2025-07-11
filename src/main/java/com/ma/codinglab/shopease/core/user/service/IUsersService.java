package com.ma.codinglab.shopease.core.user.service;

import com.ma.codinglab.shopease.core.user.model.Users;

import java.util.List;

public interface IUsersService {
    Users registerUser(Users theUser);
    Users updateUsers(Users theUser);
    Users deleteUsers(Users theUser);
    List<Users> findAllUsers();
    List<Users> findUserByActive(Boolean active);

    boolean existsByEmail(String email);
}
