package com.ma.codinglab.shopease.core.order.model;

import com.ma.codinglab.shopease.core.base.AbstractBaseEntity;
import com.ma.codinglab.shopease.core.payment.model.Payment;
import com.ma.codinglab.shopease.core.product.models.Product;
import com.ma.codinglab.shopease.core.user.model.Users;
import com.ma.codinglab.shopease.core.util.order.EOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "orders")
public class Order extends AbstractBaseEntity {
    private LocalDateTime date;
    private EOrderStatus orderStatus;
    private Integer quantity;
    private Double totalAmount;
    @ManyToOne
    @JoinColumn(name = "Product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @OneToMany(mappedBy = "order")
    private List<Payment> payments;


}
