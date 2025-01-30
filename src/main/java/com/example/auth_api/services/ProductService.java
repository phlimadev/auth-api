package com.example.auth_api.services;

import com.example.auth_api.dtos.NewProductDTO;
import com.example.auth_api.dtos.ProductDTO;
import com.example.auth_api.entities.Product;
import com.example.auth_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> findAll() {
        List<ProductDTO> allProducts = productRepository.findAll().stream().map(ProductDTO::new).toList();
        return allProducts;
    }

    public void registerProduct(NewProductDTO data) {
        Product newProduct = new Product(data);
        productRepository.save(newProduct);
    }
}
