package com.arjun.shoppingcart.shoppingcart.service;

import com.arjun.shoppingcart.shoppingcart.model.Cart;
import com.arjun.shoppingcart.shoppingcart.model.Product;
import com.arjun.shoppingcart.shoppingcart.repository.CartRepository;
import com.arjun.shoppingcart.shoppingcart.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Data
@Service
public class CartService {

    int num;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;


    public Cart saveCart(Cart cart) throws IOException {

        System.out.println(cart.getProduct().getId());
        Optional<Product> product1 = productRepository.findById(cart.getProduct().getId());
        setNum(cart.getQuantity());
        cart.setTotalAmount(getNum()*(cart.getQuantity()));

        return cartRepository.save(cart);
    }
}
