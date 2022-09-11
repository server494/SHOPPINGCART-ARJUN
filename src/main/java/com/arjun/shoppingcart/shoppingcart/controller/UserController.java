package com.arjun.shoppingcart.shoppingcart.controller;

import com.arjun.shoppingcart.shoppingcart.exception.CustomUserException;
import com.arjun.shoppingcart.shoppingcart.model.User;
import com.arjun.shoppingcart.shoppingcart.repository.UserRepository;
import com.arjun.shoppingcart.shoppingcart.response.ApiResponse;
import com.arjun.shoppingcart.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registration")
    public ResponseEntity<ApiResponse> saveUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(new ApiResponse("USER CREATED"), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ApiResponse> remove(@PathVariable int id)throws CustomUserException {

        userRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse("USER DELETED"),HttpStatus.CREATED);


    }

}
