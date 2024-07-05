package org.example.producttest.product.controller;

import org.example.producttest.file.FileUploadService;
import org.example.producttest.product.model.ProductCreateReq;
import org.example.producttest.product.model.ProductDetailRes;
import org.example.producttest.product.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final FileUploadService fileUploadService;

    public ProductController(ProductService productService,FileUploadService fileUploadService) {
        this.productService = productService;
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(
            @RequestPart ProductCreateReq dto,
            @RequestPart(name = "file") MultipartFile file
            ){
        String res = "";
        try {
            String filename = fileUploadService.upload(file);
            res = productService.create(dto,filename);
        }catch (Exception e){
            res = "등록 실패";
        }

        return ResponseEntity.ok(res);

    }

    @GetMapping("/detail?id")
    public ResponseEntity<ProductDetailRes> detailById(
            Long id
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
