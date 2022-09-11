package com.arjun.shoppingcart.shoppingcart.repository;

import com.arjun.shoppingcart.shoppingcart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Optional<Category> findById(Integer id);

}
