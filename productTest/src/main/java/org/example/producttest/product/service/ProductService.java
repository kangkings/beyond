package org.example.producttest.product.service;

import org.example.producttest.product.model.Product;
import org.example.producttest.product.model.ProductCreateReq;
import org.example.producttest.product.model.Seller;
import org.example.producttest.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public String create(ProductCreateReq req) {
        Product p = new Product();
        p.setProductName(req.getProductName());
        p.setProductPrice(req.getProductPrice());
        p.setDeliveryPrice(req.getDeliveryPrice());
        p.setAddDeliveryPrice(req.getAddDeliveryPrice());
        p.setOutboundDays(req.getOutboundDays());
        p.setSeller(new Seller(1L,"test01@gmail.com","test01","01012345678",null));
        productRepository.save(p);

        return "성공";
    }
}
