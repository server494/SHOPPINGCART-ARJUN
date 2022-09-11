package com.arjun.shoppingcart.shoppingcart.service;

import com.arjun.shoppingcart.shoppingcart.model.Order;
import com.arjun.shoppingcart.shoppingcart.model.User;
import com.arjun.shoppingcart.shoppingcart.repository.CartRepository;
import com.arjun.shoppingcart.shoppingcart.repository.OrderRepository;
import com.arjun.shoppingcart.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class OrderService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;


    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(Order order) throws IOException{


        System.out.println(cartRepository);


    }


}
