package com.example.spring_jwt_config.controller.category;

import com.example.spring_jwt_config.controller.RestApiController;
import com.example.spring_jwt_config.payload.Category.CategoryRequest;
import com.example.spring_jwt_config.service.category.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/category")
@RequiredArgsConstructor
public class CategoryController extends RestApiController {
    private final CategoryService categoryService;
    @GetMapping()
    public Object getAllCategory(){
        return ok(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public Object getCategoryById (@PathVariable("id") Long categoryId) throws Throwable {
        return ok(categoryService.findById(categoryId));
    }

    @PostMapping
    public Object createCategory(CategoryRequest payload){
        categoryService.createCategory(payload);
        return ok();
    }


}
