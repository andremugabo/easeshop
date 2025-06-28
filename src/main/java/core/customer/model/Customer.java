package core.customer.model;

import core.base.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Customer extends AbstractBaseEntity {
    @Column(name = "reg_number",nullable = false, unique = true)
    private String regNumber;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name= "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number",nullable = false, unique = true)
    private String phoneNumber;
    @Column(name = "password", nullable = false)
    private String password;
}
