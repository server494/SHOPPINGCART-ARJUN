package com.arjun.shoppingcart.shoppingcart.controller;

import com.arjun.shoppingcart.shoppingcart.model.Order;
import com.arjun.shoppingcart.shoppingcart.repository.OrderRepository;
import com.arjun.shoppingcart.shoppingcart.response.ApiResponse;
import com.arjun.shoppingcart.shoppingcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> placeOrder(@RequestBody Order order) throws IOException {
        orderService.saveOrder(order);
        return new ResponseEntity<>(new ApiResponse("ORDER PLACED"), HttpStatus.CREATED);
    }


}
