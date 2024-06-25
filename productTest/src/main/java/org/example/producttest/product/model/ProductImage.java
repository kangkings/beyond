package org.example.producttest.product.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
