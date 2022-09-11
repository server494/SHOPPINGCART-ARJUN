package com.arjun.shoppingcart.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

import java.util.Set;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "items_count")
    private int count;
    private int totalAmount;


    @Column(name = "total_price")
    private Double totalPrice;


    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date orderDate;
    @PrePersist
    private void orderDate(){
        orderDate=new Date();
    }


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinTable(name = "confirm_order",joinColumns = {@JoinColumn(name = "order_id")},
    inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> user = new HashSet<>();

    public Order() {
    }

}