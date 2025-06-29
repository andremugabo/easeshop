package com.ma.codinglab.shopease.core.customer.service;

import com.ma.codinglab.shopease.core.customer.model.Customer;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {
    Customer registerCustomer(Customer theCustomer);
    Customer updateCustomer(Customer theCustomer);
    Customer deleteCustomer(Customer theCustomer);
    List<Customer> findCustomersByActive(Boolean status);
    Customer findCustomerById(UUID Id);
}
