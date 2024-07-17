package com.example.productservice.application.service;

import com.example.productservice.application.port.in.RegisterProductCommand;
import com.example.productservice.application.port.in.RegisterProductUseCase;
import com.example.productservice.application.port.out.RegisterProductPort;
import com.example.productservice.common.UseCase;
import com.example.productservice.domain.Product;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ProductService implements RegisterProductUseCase {
    private final RegisterProductPort registerProductPort;

    @Override
    public Product registerProduct(RegisterProductCommand command) {

        Product product = Product.builder()
                .name(command.getName())
                .price(command.getPrice())
                .build();

        product = registerProductPort.createProduct(product);

        return product;
    }

}
