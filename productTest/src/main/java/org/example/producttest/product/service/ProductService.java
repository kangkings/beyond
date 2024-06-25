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
        Product p = new Product();
        ProductImage pImg = new ProductImage();
        p.setProductName(req.getProductName());
        p.setProductPrice(req.getProductPrice());
        p.setDeliveryPrice(req.getDeliveryPrice());
        p.setAddDeliveryPrice(req.getAddDeliveryPrice());
        p.setOutboundDays(req.getOutboundDays());
        p.setSeller(new Seller(1L,"test01@gmail.com","test01","01012345678",null));
        productRepository.save(p);
        pImg.setImageUrl(name);
        pImg.setProduct(p);
        productImageRepository.save(pImg);

        return "성공";
    }



    public ProductDetailRes detailById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDetailRes res = new ProductDetailRes();
        res.setId(product.getId());
        res.setAddDeliveryPrice(product.getAddDeliveryPrice());
        res.setProductName(product.getProductName());
        res.setSellerName(product.getSeller().getName());
        res.setDeliveryPrice(product.getDeliveryPrice());
        res.setOutboundDays(product.getOutboundDays());
        res.setImageUrl(product.getProductImage().getImageUrl());

        return res;
    }

    public List<ProductDetailRes> detailList() {
        List<Product> product = productRepository.findAll();
        List<ProductDetailRes> res = new ArrayList<>();
        for (Product p : product){
            ProductDetailRes pRes = new ProductDetailRes();
            pRes.setId(p.getId());
            pRes.setAddDeliveryPrice(p.getAddDeliveryPrice());
            pRes.setDeliveryPrice(p.getDeliveryPrice());
            pRes.setOutboundDays(p.getOutboundDays());
            pRes.setProductName(p.getProductName());
            pRes.setSellerName(p.getSeller().getName());
            pRes.setImageUrl(p.getProductImage().getImageUrl());
            res.add(pRes);
        }
        return res;
    }
}
