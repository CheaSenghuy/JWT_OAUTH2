package com.example.spring_jwt_config.service.product;

import com.example.spring_jwt_config.common.api.StatusCode;
import com.example.spring_jwt_config.domain.category.CategoryRepository;
import com.example.spring_jwt_config.domain.product.Product;
import com.example.spring_jwt_config.domain.product.ProductRepository;
import com.example.spring_jwt_config.exception.BusinessException;
import com.example.spring_jwt_config.payload.product.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) throws Throwable {
        var prodcut = productRepository.findById(productId).orElseThrow(()-> new BusinessException(StatusCode.NOT_FOUND, "Product ID is not found"));
        return prodcut;
    }

    @Override
    public void createProduct(ProductRequest payload) {
        var category = categoryRepository.findById(payload.getCategoryId()).orElseThrow(()-> new BusinessException(StatusCode.NOT_FOUND,"Category not found"));
        var product = Product.builder()
                .name(payload.getName())
                .qty(payload.getQty())
                .category(category)
                .price(payload.getPrice())
                .productImage(payload.getProductImage())
                .build();
        productRepository.save(product);
    }

    @Override
    public void modifyProduct(ProductRequest payload, Long productID) {
        var category = categoryRepository.findById(payload.getCategoryId()).orElseThrow(()-> new BusinessException(StatusCode.NOT_FOUND,"Category not found"));
        var product = productRepository.findById(productID).orElseThrow(()-> new BusinessException(StatusCode.NOT_FOUND,"Product not found"));
        product = Product.builder()
                .name(payload.getName())
                .qty(payload.getQty())
                .category(category)
                .price(payload.getPrice())
                .productImage(payload.getProductImage())
                .build();
        productRepository.save(product);
    }
}
