package org.example.producttest.product.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

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
    @JoinColumn(name = "seller_idx")
    private Seller seller;
}
