package com.ma.codinglab.shopease.core.customer.repository;

import com.ma.codinglab.shopease.core.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByIdAndActive(UUID Id, Boolean status);
    Optional<Customer> findByEmailAndPassword(String email, String password);
    Optional<Customer> findByActive(Boolean status);
    List<Customer> findAllByActive(Boolean status);
}
