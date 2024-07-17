package com.example.productservice.adapter.in.web;

import com.example.productservice.application.port.in.RegisterProductCommand;
import com.example.productservice.application.port.in.RegisterProductUseCase;
import com.example.productservice.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterProductController {

    private final RegisterProductUseCase useCase;

    @RequestMapping(method = RequestMethod.POST, value = "/product/register")
    public ResponseEntity register(@RequestBody RegisterProductRequest request) {
        System.out.println(request.getName());
        RegisterProductCommand command = RegisterProductCommand.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
        return ResponseEntity.ok().body(useCase.registerProduct(command));
    }
}
