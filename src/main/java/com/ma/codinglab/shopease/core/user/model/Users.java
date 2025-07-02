package com.ma.codinglab.shopease.core.user.model;


import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.order.model.Order;
import com.ma.codinglab.shopease.core.payment.model.Payment;
import com.ma.codinglab.shopease.core.review.model.Review;
import com.ma.codinglab.shopease.core.userNotification.model.UserNotification;
import com.ma.codinglab.shopease.core.util.user.EUserAuthProvider;
import com.ma.codinglab.shopease.core.util.user.EUserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.ma.codinglab.shopease.core.address.model.Address;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Users extends AbstractBaseEntity {
    @Column(name = "first_name",nullable = false)
    private String firstname;
    @Column(name = "last_name",nullable = false)
    private String lastname;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private EUserRole userRole;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "phone",nullable = false,unique = true)
    private String phone;
    private String password;
    @Transient
    private String confirmPassword;
    @Column(nullable = true)
    private String image;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EUserAuthProvider authProvider;
    private Boolean isVerified = Boolean.FALSE;
    private Boolean isPasswordExpired = Boolean.FALSE;
    private Boolean isSubscribed = Boolean.FALSE;
    private String otpCode;
    private String otpPurpose;
    private LocalDateTime otpExpiresAt;
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
    @OneToMany(mappedBy = "user")
    private List<Payment> payments;
    @OneToMany(mappedBy = "user")
    private List<UserNotification> userNotifications;


}
