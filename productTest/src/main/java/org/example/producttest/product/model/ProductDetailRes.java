package org.example.producttest.product.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDetailRes {
    private Long id;
    private String productName;
    private Integer deliveryPrice;

    private Integer addDeliveryPrice;
    private Integer outboundDays;
    private String sellerName;
    private String imageURL;

}
