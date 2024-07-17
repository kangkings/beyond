package com.example.productreviewservice.adapter.in.web;

import com.example.productreviewservice.application.port.in.RegisterProductReviewCommand;
import com.example.productreviewservice.application.port.in.RegisterProductReviewUseCase;
import com.example.productreviewservice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@WebAdapter
@RequiredArgsConstructor
public class RegisterProductReviewController {

    private final RegisterProductReviewUseCase useCase;

    @RequestMapping(method = RequestMethod.POST, value = "/product/register")
    public ResponseEntity register(
            @RequestBody RegisterProductReviewRequest request) {
        RegisterProductReviewCommand command = RegisterProductReviewCommand.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
        return ResponseEntity.ok().body(useCase.registerProductReview(command));
    }
}
