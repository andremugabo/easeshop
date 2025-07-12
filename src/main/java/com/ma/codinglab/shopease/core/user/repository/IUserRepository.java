package com.ma.codinglab.shopease.core.user.repository;


import com.ma.codinglab.shopease.core.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<Users, UUID> {
        List<Users> findByActive(Boolean active);
        Optional<Users> findByEmail(String email);
        Optional<Users> findByPhone(String phone);
        boolean existsByEmail(String email);
        boolean existsByPhone(String phone);
}
