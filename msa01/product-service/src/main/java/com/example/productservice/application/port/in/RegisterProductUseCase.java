package com.example.productservice.application.port.in;


import com.example.productservice.domain.Product;

public interface RegisterProductUseCase {
    Product registerProduct(RegisterProductCommand registerProductCommand);

}
