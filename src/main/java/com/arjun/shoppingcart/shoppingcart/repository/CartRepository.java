package com.arjun.shoppingcart.shoppingcart.repository;

import com.arjun.shoppingcart.shoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart> findById(Integer id);
}
