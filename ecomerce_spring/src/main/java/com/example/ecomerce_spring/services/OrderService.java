package com.example.ecomerce_spring.services;

import com.example.ecomerce_spring.dto.OrderItemRequest;
import com.example.ecomerce_spring.dto.OrderRequest;
import com.example.ecomerce_spring.entities.Order;
import com.example.ecomerce_spring.entities.OrderItem;
import com.example.ecomerce_spring.entities.Product;
import com.example.ecomerce_spring.repositories.OrderRepository;
import com.example.ecomerce_spring.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    BigDecimal totalPrice = BigDecimal.ZERO;
    List<OrderItem> orderItems = new ArrayList<>();

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Order createOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setStatus("CONFIRMED");

        for(OrderItemRequest itemRequest : orderRequest.getItems()){
            Product product = productRepository.findById(
                    itemRequest.getProductId()
            ).orElseThrow(() ->new RuntimeException(
                    "product not found with id : "+itemRequest.getProductId()
            ));
            //        check the product stock
            if(product.getStockQuantity() < itemRequest.getQuantity()){
                throw new RuntimeException("not enough stock for "+itemRequest.getProductId());
            }
//            calculate total price
            BigDecimal priceOfItem = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
            totalPrice = totalPrice.add(priceOfItem);

//            update the product table with latest stock quantity
            product.setStockQuantity(
                    product.getStockQuantity() - itemRequest.getQuantity()
            );
            productRepository.save(product);

//            builder pattern to make object
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(itemRequest.getQuantity())
                    .priceAtPurchase(product.getPrice())
                    .build();

            orderItems.add(orderItem);

        }
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);
        return orderRepository.save(order);
    }
}
