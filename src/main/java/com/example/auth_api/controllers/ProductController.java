package com.example.auth_api.controllers;

import com.example.auth_api.dtos.NewProductDTO;
import com.example.auth_api.dtos.ProductDTO;
import com.example.auth_api.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> allProducts = productService.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid NewProductDTO data) {
        productService.registerProduct(data);
        return ResponseEntity.ok().build();
    }
}
