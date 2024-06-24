package org.example.producttest.product.controller;

import org.example.producttest.product.model.ProductCreateReq;
import org.example.producttest.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(
            @RequestBody ProductCreateReq req
            ){
        String res = "";
        try {
            res = productService.create(req);
        }catch (Exception e){
            res = "등록 실패";
        }

        return ResponseEntity.ok(res);

    }
}
