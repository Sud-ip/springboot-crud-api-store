package com.example.ecomerce_spring.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    @NotBlank(message = "customer name is required")
    private String customerName;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "customer email is required")
    private String customerEmail;

    @Valid
    @NotEmpty(message = "order must contain at least one item")
    private List<OrderItemRequest> items;
}
