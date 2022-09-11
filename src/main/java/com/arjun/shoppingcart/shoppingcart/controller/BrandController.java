package com.arjun.shoppingcart.shoppingcart.controller;

import com.arjun.shoppingcart.shoppingcart.exception.CustomUserException;
import com.arjun.shoppingcart.shoppingcart.model.Brand;
import com.arjun.shoppingcart.shoppingcart.repository.BrandRepository;
import com.arjun.shoppingcart.shoppingcart.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/brand")
@RestController
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> placeBrand(@Valid @RequestBody Brand brand){

        brandRepository.save(brand);
        return new ResponseEntity<>(new ApiResponse("BRAND ADDED"), HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public List<Brand> displayBrands(){
        return brandRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Brand findBrandById(@PathVariable int id)throws CustomUserException{

        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()){

        }
        return brand.get();
    }

}
