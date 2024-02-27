package com.example.spring_jwt_config.service.category;

import com.example.spring_jwt_config.common.api.StatusCode;
import com.example.spring_jwt_config.domain.category.Category;
import com.example.spring_jwt_config.domain.category.CategoryRepository;
import com.example.spring_jwt_config.exception.BusinessException;
import com.example.spring_jwt_config.payload.Category.CategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryRequest payload) {
        Category category = Category.builder()
                .name(payload.getName())
                .build();
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Long categoryId) throws Throwable {
        var category =  categoryRepository.findById(categoryId).orElseThrow(() -> new BusinessException(StatusCode.NOT_FOUND,"ID not Found"));
        return category;
    }

    @Override
    public Object findAll() {
        return categoryRepository.findAll();
    }
}
