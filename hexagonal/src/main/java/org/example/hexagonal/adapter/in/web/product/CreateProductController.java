package org.example.hexagonal.adapter.in.web.product;

import lombok.RequiredArgsConstructor;
import org.example.hexagonal.application.port.in.product.ProductCreateUseCase;
import org.example.hexagonal.common.WebAdapter;

@WebAdapter
@RequiredArgsConstructor
public class ProductCreateController {

    private final ProductCreateUseCase useCase;
}
