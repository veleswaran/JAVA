package com.example.crud.service;

import com.example.crud.entity.product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public product saveProduct(product product1){
       return repository.save(product1);
    }
    public List<product> saveProducts(List<product> products){
        return repository.saveAll(products);
    }

    public List<product> getProducts(){
        return repository.findAll();
    }

    public product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public product getProductByName(String name){
        return repository.findByName(name);
    }
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed || "+id;
    }

    public product updateProduct(product product1){
        product existingProduct= repository.findById(product1.getId()).orElse(null);
        existingProduct.setName(product1.getName());
        existingProduct.setQuantity(product1.getQuantity());
        existingProduct.setPrice(product1.getPrice());
        return repository.save(existingProduct);
    }
}
