package com.example.ecomerce_spring.repositories;

import com.example.ecomerce_spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
