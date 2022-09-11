package com.arjun.shoppingcart.shoppingcart.controller;


import com.arjun.shoppingcart.shoppingcart.exception.CustomUserException;
import com.arjun.shoppingcart.shoppingcart.model.Category;
import com.arjun.shoppingcart.shoppingcart.repository.CategoryRepository;
import com.arjun.shoppingcart.shoppingcart.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> placeCategory(@Valid @RequestBody Category category){

        categoryRepository.save(category);
        return new ResponseEntity<>(new ApiResponse("CATEGORY ADDED"), HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public List<Category> displayCategory(){
        return categoryRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Category findCategoryById(@PathVariable int id)throws CustomUserException {

        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()){

        }
        return category.get();
    }

}