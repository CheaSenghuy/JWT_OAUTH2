package com.example.spring_jwt_config.service.product;

import com.example.spring_jwt_config.domain.product.Product;
import com.example.spring_jwt_config.payload.product.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product findById(Long productId) throws Throwable ;
    void createProduct(ProductRequest payload);

    void modifyProduct(ProductRequest payload,Long productID);
}
