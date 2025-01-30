package com.example.auth_api.entities;

import com.example.auth_api.dtos.NewProductDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;

    public Product(NewProductDTO newProduct) {
        this.name = newProduct.name();
        this.price_in_cents = newProduct.price_in_cents();
    }
}
