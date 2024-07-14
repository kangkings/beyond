package com.example.productreviewservice.adapter.out.persistence;

import com.example.productreviewservice.application.port.out.RegisterProductReviewPort;
import com.example.productreviewservice.common.PersistenceAdapter;
import com.example.productreviewservice.domain.ProductReview;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterProductReviewPersistenceAdapter implements RegisterProductReviewPort {
    private final JpaProductReviewRepository jpaProductReviewRepository;

    @Override
    public ProductReview createProductReview(ProductReview product) {
        ProductReviewEntity productEntity = ProductReviewEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
        productEntity = jpaProductReviewRepository.save(productEntity);
        return ProductReview.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }

}
