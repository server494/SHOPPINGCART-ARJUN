package com.arjun.shoppingcart.shoppingcart.service;

import com.arjun.shoppingcart.shoppingcart.model.Cart;
import com.arjun.shoppingcart.shoppingcart.model.Order;
import com.arjun.shoppingcart.shoppingcart.repository.CartRepository;
import com.arjun.shoppingcart.shoppingcart.repository.OrderRepository;
import com.arjun.shoppingcart.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {


    Cart cart;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) throws IOException{

        order.setCount((int) cart.getQuantity());
        List<Integer> cartItem1 = Collections.singletonList(cart.getId());
        List<Cart> carts = cartRepository.findAllById(cartItem1);
        int num = carts.stream().mapToInt(p-> p.getTotalAmount()).sum();
        order.setTotalAmount(num);
        if (cart.getId()==order.getId()){
            cartRepository.deleteById(cart.getId());
        }
        orderRepository.save(order);

    }


}
