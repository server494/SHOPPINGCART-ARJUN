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

    Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    public Cart saveCart(Cart cart) throws IOException {

        Optional<Product> pro = productRepository.findById(cart.getProduct().getId());

        return null;
    }
}
