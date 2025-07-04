package com.ma.codinglab.shopease.core.user.service;

import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements IUsersService{

    private final IUserRepository userRepository;

    @Override
    public Users registerUser(Users theUser) {
        return null;
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
}
