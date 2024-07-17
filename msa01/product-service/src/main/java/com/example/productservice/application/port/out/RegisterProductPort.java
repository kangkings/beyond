package com.example.productservice.application.port.out;

import com.example.productservice.domain.Product;

public interface RegisterProductPort {
    Product createProduct(Product product);
}
