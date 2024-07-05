package org.example.tdd.product;

import lombok.RequiredArgsConstructor;
import org.example.tdd.product.model.ProductCreateReq;
import org.example.tdd.product.model.ProductViewRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductViewRes> create(
            @RequestBody ProductCreateReq req
            ){
        ProductViewRes res = productService.save(req);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity<ProductViewRes> read(
            @PathVariable(name = "idx") Long idx
    ){
        ProductViewRes res = productService.findById(idx);

        return ResponseEntity.ok(res);
    }


    @GetMapping("/read/all")
    public ResponseEntity<List<ProductViewRes>> readAll(){
        List<ProductViewRes> res = productService.findAll();
        return ResponseEntity.ok(res);
    }
}
