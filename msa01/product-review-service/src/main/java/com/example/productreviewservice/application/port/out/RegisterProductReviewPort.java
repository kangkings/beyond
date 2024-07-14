package com.example.productreviewservice.application.port.out;


import com.example.productreviewservice.domain.ProductReview;

public interface RegisterProductReviewPort {
    ProductReview createProductReview(ProductReview product);
}
