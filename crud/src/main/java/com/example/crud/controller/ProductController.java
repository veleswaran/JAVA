package com.example.crud.controller;

import com.example.crud.service.ProductService;
import com.example.crud.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public product addProduct(@RequestBody product product1){
        return service.saveProduct(product1);
    }

    @PostMapping("/addproducts")
    public List<product> addProducts(@RequestBody List<product> product1){
        return service.saveProducts(product1);
    }

    @GetMapping("/products")
    public List<product> findAllPrudoct(){
        return service.getProducts();
    }

    @GetMapping("/product/{id}")
    public product findProductById(int id){
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public product findProductByName(String name){
        return service.getProductByName(name);
    }

    @PutMapping ("/update")
    public product updateProduct(@RequestBody product product1){
        return service.updateProduct(product1);
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }





}
