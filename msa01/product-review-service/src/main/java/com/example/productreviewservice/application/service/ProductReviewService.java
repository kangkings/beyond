package com.example.productreviewservice.application.service;

import com.example.productreviewservice.application.port.in.RegisterProductReviewCommand;
import com.example.productreviewservice.application.port.in.RegisterProductReviewUseCase;
import com.example.productreviewservice.application.port.out.RegisterProductReviewPort;
import com.example.productreviewservice.common.UseCase;
import com.example.productreviewservice.domain.ProductReview;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class ProductReviewService implements RegisterProductReviewUseCase {
    private final RegisterProductReviewPort registerProductReviewPort;

    @Override
    public ProductReview registerProductReview(RegisterProductReviewCommand command) {

        ProductReview product = ProductReview.builder()
                .name(command.getName())
                .price(command.getPrice())
                .build();

        product = registerProductReviewPort.createProductReview(product);

        return product;
    }

}
