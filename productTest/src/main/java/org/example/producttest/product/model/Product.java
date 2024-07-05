package org.example.producttest.product.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private Integer productPrice;

    @Column
    private Integer deliveryPrice;
    @Column
    private Integer addDeliveryPrice;
    @Column
    private Integer outboundDays;


    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToOne(mappedBy = "product")
    private ProductImage productImage;

    public ProductDetailRes toDto(Product product) {
        return ProductDetailRes.builder()
                .id(this.id)
                .productName(this.getProductName())
                .deliveryPrice(this.deliveryPrice)
                .addDeliveryPrice(this.addDeliveryPrice)
                .outboundDays(this.outboundDays)
                .sellerName(this.getSeller().getName())
                .imageUrl(this.productImage.getImageUrl())
                .build();
    }
}
