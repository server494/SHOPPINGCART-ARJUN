package com.arjun.shoppingcart.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Size(min = 2,message = "USERNAME CANNOT BE EMPTY")
    private String username;
    @Email(message = "INVALID EMAIL")
    @NotEmpty
    private String email;

    @Size(min = 2,message = "PASSWORD CANNOT BE EMPTY")
    private String password;

    @NotEmpty
    @Size(message = "PHONE NUMBER CANNOT BE EMPTY")
    @Pattern(regexp = "^\\d{10}$")
    private String phone;

    @NotEmpty
    @Size(message = "ROLE CANNOT BE EMPTY")
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Order> orders;


    public User() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public User(String username, String email, String password, String phone, String role, List<Order> orders) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.orders = orders;
    }
}