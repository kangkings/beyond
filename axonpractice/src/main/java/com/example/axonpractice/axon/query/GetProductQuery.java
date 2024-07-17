package com.example.axonpractice.axon.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProductQuery {
    private String id;

    private String name;
    private Integer price;
    private Integer amount;
}
