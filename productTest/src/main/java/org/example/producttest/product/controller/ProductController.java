package org.example.producttest.product.controller;

import org.example.producttest.product.model.ProductCreateReq;
import org.example.producttest.product.model.ProductDetailRes;
import org.example.producttest.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/detail/{id}")
    public ResponseEntity<ProductDetailRes> detailById(
            @PathVariable(name = "id") Long id
    ){
        ProductDetailRes res = productService.detailById(id);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDetailRes>> detailList(){
        List<ProductDetailRes> res = productService.detailList();
        return ResponseEntity.ok(res);
    }
}
