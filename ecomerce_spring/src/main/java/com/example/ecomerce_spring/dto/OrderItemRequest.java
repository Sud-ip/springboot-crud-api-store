package com.example.ecomerce_spring.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequest {
    @NotNull(message = "product id is required")
    private Long productId;

    @Min(value = 1,message = "quantity must be at least 1")
    @NotNull(message = "quantity is required")
    private Integer quantity;
}
