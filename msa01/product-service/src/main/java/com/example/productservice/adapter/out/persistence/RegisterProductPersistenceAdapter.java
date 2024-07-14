package com.example.productservice.adapter.out.persistence;

import com.example.productservice.application.port.out.RegisterProductPort;
import com.example.productservice.common.PersistenceAdapter;
import com.example.productservice.domain.Product;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterProductPersistenceAdapter implements RegisterProductPort {
    private final JpaProductRepository jpaProductRepository;

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
        productEntity = jpaProductRepository.save(productEntity);
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }

}
