package com.example.ecomerce_spring.repositories;

import com.example.ecomerce_spring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
