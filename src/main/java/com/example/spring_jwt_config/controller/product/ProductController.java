package com.example.spring_jwt_config.controller.product;

import com.example.spring_jwt_config.controller.RestApiController;
import com.example.spring_jwt_config.payload.product.ProductRequest;
import com.example.spring_jwt_config.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController extends RestApiController {
    private final ProductService productService;

    @GetMapping
    public Object getAllProduct(){
        return ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public Object getProductById (@PathVariable("id") Long productId) throws Throwable {
        return ok(productService.findById(productId));
    }

    @PostMapping
    public Object createProduct (@RequestBody ProductRequest payload) {
        productService.createProduct(payload);
        return ok();
    }

    @PutMapping("/{id}")
    public Object modifyProduct(@RequestBody ProductRequest productRequest, @PathVariable("id") Long productId){
        productService.modifyProduct(productRequest, productId);
        return ok();
    }

}
