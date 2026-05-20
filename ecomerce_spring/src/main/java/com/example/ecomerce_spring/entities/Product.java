package com.example.ecomerce_spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "product name is required")
    @Column(nullable = false)
    private String name;


    private  String description;


    private String category;

    @NotNull(message = "price is required")
    @DecimalMin(value = "0.0",inclusive = false,message = "price must be greater than 0")
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0,message = "Strock must be greater than 0")
    @Column(name = "stock_quantity",nullable = false)
    private Integer stockQuantity;

    @OneToMany(mappedBy = "product")
    private List<orderItem> orderItems;
}
