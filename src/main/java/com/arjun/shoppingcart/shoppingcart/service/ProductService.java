package com.arjun.shoppingcart.shoppingcart.service;

import com.arjun.shoppingcart.shoppingcart.model.Brand;
import com.arjun.shoppingcart.shoppingcart.model.Category;
import com.arjun.shoppingcart.shoppingcart.model.Product;
import com.arjun.shoppingcart.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product store(MultipartFile file, String name, double price, Category category, Brand brand)throws IOException{

        String fileName = file.getOriginalFilename();
        Product product = new  Product(name,price,category,brand,fileName,file.getContentType(),file.getBytes());
        return productRepository.save(product);
    }
    public Product save(Product product){
        return this.productRepository.save(product);
    }

}
