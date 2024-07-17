package com.example.axonpractice.axon.query;

import com.example.axonpractice.product.Product;
import com.example.axonpractice.product.ProductRepository;
import com.example.axonpractice.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    @QueryHandler(queryName = "list")
    private List<ProductDto> getProducts(String dumn){
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product p : products){
            ProductDto dto = ProductDto.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .price(p.getPrice())
                    .amount(p.getAmount())
                    .build();
            productDtos.add(dto);
        }

        return productDtos;

    }

    @QueryHandler(queryName = "get")
    private ProductDto getProduct(GetProductQuery query){
        Optional<Product> res = productRepository.findById(query.getId());
        if (res.isPresent()){
            Product product = res.get();
            ProductDto productDto = ProductDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .amount(product.getAmount())
                    .build();
            return productDto;

        }
        return null;
    }
}
