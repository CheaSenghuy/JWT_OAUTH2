package com.example.spring_jwt_config.domain.product;

import com.example.spring_jwt_config.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategory(Category category);
}
