package com.example.auth_api.dtos;

import com.example.auth_api.entities.Product;

public record ProductDTO(String id, String name, Integer price_in_cents) {
    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice_in_cents());
    }
}
