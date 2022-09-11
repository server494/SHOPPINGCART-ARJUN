package com.arjun.shoppingcart.shoppingcart.repository;

import com.arjun.shoppingcart.shoppingcart.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    public Optional<Brand> findById(Integer id);
}
