package org.example.tdd.product;

import lombok.RequiredArgsConstructor;
import org.example.tdd.product.model.Product;
import org.example.tdd.product.model.ProductCreateReq;
import org.example.tdd.product.model.ProductViewRes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public ProductViewRes save(ProductCreateReq req) {
        Product product =  productRepository.save(req.toEntity());


        return product.toViewRes();
    }

    public ProductViewRes findById(Long idx){
        Optional<Product> product = productRepository.findById(idx);

        if (product.isEmpty()){
            return  null;
        }

        return product.get().toViewRes();
    }

    public List<ProductViewRes> findAll(){
        List<Product> resList = productRepository.findAll();
        List<ProductViewRes> res = new ArrayList<>();
        for(Product p : resList){
            res.add(p.toViewRes());
        }
        return res;
    }
}
