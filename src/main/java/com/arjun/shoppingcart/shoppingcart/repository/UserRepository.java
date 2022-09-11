package com.arjun.shoppingcart.shoppingcart.repository;

import com.arjun.shoppingcart.shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findById(Integer id);
    User findByUsername(String username);

}
