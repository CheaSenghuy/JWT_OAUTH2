package com.example.spring_jwt_config.domain.product;

import com.example.spring_jwt_config.domain.category.Category;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String productImage;
    private Double price;
    private Long qty;
    @ManyToOne
    private Category category;

    @Builder
    public Product(String name, String productImage, Double price, Long qty, Category category) {
        this.name = name;
        this.productImage = productImage;
        this.price = price;
        this.qty = qty;
        this.category = category;
    }
}
