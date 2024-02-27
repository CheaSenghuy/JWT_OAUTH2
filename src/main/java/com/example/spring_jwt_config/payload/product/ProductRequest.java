package com.example.spring_jwt_config.payload.product;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotNull
    @NotBlank
    private String name;
    private String productImage;
    private Double price;
    private Long qty;
    private Long categoryId;
}
