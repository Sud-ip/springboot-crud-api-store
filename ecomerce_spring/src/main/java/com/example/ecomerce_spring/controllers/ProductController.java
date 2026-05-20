package com.example.ecomerce_spring.controllers;

import com.example.ecomerce_spring.entities.Product;
import com.example.ecomerce_spring.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product){
        return  productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct (@PathVariable Long id,@Valid @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(Long id){
        productService.deleteProduct(id);

    }
}
