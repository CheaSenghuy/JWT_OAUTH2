package com.example.spring_jwt_config.service.category;

import com.example.spring_jwt_config.domain.category.Category;
import com.example.spring_jwt_config.payload.Category.CategoryRequest;

public interface CategoryService {
    void createCategory(CategoryRequest payload);
    Category findById(Long categoryId) throws Throwable;
    Object findAll();
}
