package com.arjun.shoppingcart.shoppingcart.repository;

import com.arjun.shoppingcart.shoppingcart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Optional<Order> findById(Integer id);


}
