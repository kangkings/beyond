package org.example.producttest.product.service;

import org.example.producttest.product.model.*;
import org.example.producttest.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;
    SellerRepository sellerRepository;
    ProductImageRepository productImageRepository;

    public ProductService(ProductRepository productRepository, SellerRepository sellerRepository, ProductImageRepository productImageRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.productImageRepository = productImageRepository;
    }

    public String create(ProductCreateReq req, String name) {
        Product p = Product.builder()
                .productName(req.getProductName())
                .productPrice(req.getProductPrice())
                .deliveryPrice(req.getDeliveryPrice())
                .addDeliveryPrice(req.getAddDeliveryPrice())
                .outboundDays(req.getOutboundDays())
                .seller(Seller.builder()
                        .id(1L)
                        .products(null)
                        .email("test01@gmail.com")
                        .name("test01")
                        .phone("010123456787")
                        .build())
                .build();

        productRepository.save(p);
        ProductImage pImg = ProductImage.builder()
                .imageUrl(name)
                .product(p)
                .build();
        productImageRepository.save(pImg);

        return "성공";
    }



    public ProductDetailRes detailById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDetailRes res = product.toDto(product);
        return res;
    }

    public List<ProductDetailRes> detailList() {
        List<Product> product = productRepository.findAll();
        List<ProductDetailRes> res = new ArrayList<>();
        for (Product p : product){
            ProductDetailRes pRes = p.toDto(p);
            res.add(pRes);
        }
        return res;
    }
}
