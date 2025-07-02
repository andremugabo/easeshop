package com.ma.codinglab.shopease.core.customer.service;

import com.ma.codinglab.shopease.core.customer.model.Customer;
import com.ma.codinglab.shopease.core.customer.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements ICustomerService{

    private final ICustomerRepository customerRepository;


    @Override
    public Customer registerCustomer(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    @Override
    public Customer updateCustomer(Customer theCustomer) {
        Customer found = customerRepository.findById(theCustomer.getId())
                .orElseThrow(()-> new ObjectNotFoundException(Customer.class,"Customer not found"));
        found.setFirstName(theCustomer.getFirstName());
        found.setLastName(theCustomer.getLastName());
        found.setEmail(theCustomer.getEmail());
        found.setPhoneNumber(theCustomer.getPhoneNumber());
        return customerRepository.save(found);
    }

    @Override
    public Customer deleteCustomer(Customer theCustomer) {
        Customer found = findCustomerById(theCustomer.getId());
        if(Objects.nonNull(found)){
            found.setActive(Boolean.FALSE);
            return customerRepository.save(found);
        }
        throw new ObjectNotFoundException(Customer.class, "The Customer not found");
    }

    @Override
    public List<Customer> findCustomersByActive(Boolean status) {
        return customerRepository.findAllByActive(Boolean.TRUE);
    }

    @Override
    public Customer findCustomerById(UUID Id) {

        return customerRepository.findById(Id)
                .orElseThrow(()-> new ObjectNotFoundException(Customer.class,"Customer Not Found"));
    }
}