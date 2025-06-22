package com.ma.codinglab.shopease.core.customer.model;


import jakarta.persistence.Entity;

import java.util.UUID;


@Entity
public class Customer {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean active;

}
