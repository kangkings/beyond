package org.example.producttest.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String email;

    private String name;
    private String phone;

    public Seller(Long idx, String email, String name, String phone) {
        this.idx = idx;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    @OneToMany(mappedBy = "seller")
    private List<Product> products = new ArrayList<>();

}
