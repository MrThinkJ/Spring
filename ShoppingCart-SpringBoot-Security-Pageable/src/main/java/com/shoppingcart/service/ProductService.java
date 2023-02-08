package com.shoppingcart.service;

import com.shoppingcart.entity.Product;
import com.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> productList(){
        return productRepository.findAll();
    }

    public Product findById(int id){
        return productRepository.findById(id).get();
    }
}
