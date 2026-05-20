package com.example.ecomerce_spring.repositories;

import com.example.ecomerce_spring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
