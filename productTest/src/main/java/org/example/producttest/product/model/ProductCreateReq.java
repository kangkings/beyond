package org.example.producttest.product.model;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductCreateReq {

private String productName;
private Integer productPrice;

private Integer deliveryPrice;
private Integer addDeliveryPrice;

private Integer outboundDays;
}
