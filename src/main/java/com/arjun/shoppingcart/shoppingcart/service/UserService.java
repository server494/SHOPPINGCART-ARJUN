package com.arjun.shoppingcart.shoppingcart.service;

import com.arjun.shoppingcart.shoppingcart.advice.ValidationExceptionHandler;
import com.arjun.shoppingcart.shoppingcart.model.User;
import com.arjun.shoppingcart.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    ValidationExceptionHandler validationExceptionHandler;

    @Autowired
    private UserRepository userRepository;

    PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user){

        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return this.userRepository.save(user);
    }

}
