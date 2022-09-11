package com.arjun.shoppingcart.shoppingcart.controller;

import com.arjun.shoppingcart.shoppingcart.model.Brand;
import com.arjun.shoppingcart.shoppingcart.model.Category;
import com.arjun.shoppingcart.shoppingcart.repository.ProductRepository;
import com.arjun.shoppingcart.shoppingcart.response.ApiResponse;
import com.arjun.shoppingcart.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("/product")
@RestController
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/save")
    public ResponseEntity<ApiResponse> uploadFile(@Valid @RequestParam("name")String name,
                                                  @RequestParam("price")double price,
                                                  @RequestParam("category_id")Category category,
                                                  @RequestParam("brand_id")Brand brand,
                                                  @RequestParam("file")MultipartFile file)throws IOException{

        productService.store(file,name,price,category,brand);
        return new ResponseEntity<>(new ApiResponse("PRODUCT ADDED"), HttpStatus.CREATED);
    }

}
