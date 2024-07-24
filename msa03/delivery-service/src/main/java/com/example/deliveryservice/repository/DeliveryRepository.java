package com.example.deliveryservice.repository;

import com.example.deliveryservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, String> {
    Optional<Delivery> findByOrderId(String orderId);
}
