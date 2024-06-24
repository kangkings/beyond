package org.example.producttest.product.repository;

import org.example.producttest.product.model.Product;
import org.example.producttest.product.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
