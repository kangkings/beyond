package org.example.producttest.product.model;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDetailRes {
    private Long id;
    private String productName;
    private Integer deliveryPrice;

    private Integer addDeliveryPrice;
    private Integer outboundDays;
    private String sellerName;
    private String imageUrl;

    public Product toEntity(Seller seller){
        return Product.builder()
                .id(this.id)
                .productName(this.productName)
                .deliveryPrice(this.deliveryPrice)
                .addDeliveryPrice(this.addDeliveryPrice)
                .outboundDays(this.outboundDays)
                .seller(seller)
                .build();
    }

}
