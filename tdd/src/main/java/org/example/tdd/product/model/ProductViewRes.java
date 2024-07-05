package org.example.tdd.product.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductViewRes {
    private Long idx;
    private String name;
    private String description;
    private Integer price;

    public Product toEntity(){
        return Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }
}
