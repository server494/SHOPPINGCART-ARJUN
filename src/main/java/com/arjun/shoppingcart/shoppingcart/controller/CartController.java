package com.arjun.shoppingcart.shoppingcart.controller;

import com.arjun.shoppingcart.shoppingcart.model.Cart;
import com.arjun.shoppingcart.shoppingcart.repository.CartRepository;
import com.arjun.shoppingcart.shoppingcart.response.ApiResponse;
import com.arjun.shoppingcart.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;


    @PostMapping("/save")
    public ResponseEntity<ApiResponse> placeCartItem(@Valid @RequestBody Cart cart)throws IOException{

        cartService.saveCart(cart);
        return new ResponseEntity<>(new ApiResponse("CART ITEM ADDED"), HttpStatus.CREATED);

    }
//    @DeleteMapping("/remove/{id}")
//    public ResponseEntity<ApiResponse> removeCartItemById(@PathVariable int id){
//        cartRepository.delete(cartRepository.findById(id));
//        return new ResponseEntity<>(new ApiResponse("CART ITEM DELETED"),HttpStatus.OK);
//    }


}
