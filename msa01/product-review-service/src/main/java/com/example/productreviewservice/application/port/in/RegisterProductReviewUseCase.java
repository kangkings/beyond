package com.example.productreviewservice.application.port.in;


import com.example.productreviewservice.domain.ProductReview;

public interface RegisterProductReviewUseCase {
    ProductReview registerProductReview(RegisterProductReviewCommand registerProductReviewCommand);

}
