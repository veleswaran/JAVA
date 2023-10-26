package com.example.crud.repository;
import com.example.crud.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<product,Integer> {
    product findByName(String name);
}
