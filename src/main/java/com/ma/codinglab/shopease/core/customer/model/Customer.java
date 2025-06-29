package com.ma.codinglab.shopease.core.customer.model;


import core.base.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@Entity
public class Customer extends AbstractBaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number",nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "password")
    private String password;
    @Transient
    private String confirmPassword;
}
