package com.ma.codinglab.shopease.core.payment.model;

import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.order.model.Order;
import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.util.payment.EPaymentCurrencyType;
import com.ma.codinglab.shopease.core.util.payment.EPaymentMode;
import com.ma.codinglab.shopease.core.util.payment.EPaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "payment")
public class Payment extends AbstractBaseEntity {;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EPaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EPaymentCurrencyType paymentCurrencyType;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EPaymentMode paymentMode;
    private String transactionId;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;



}
