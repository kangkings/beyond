package org.example.tdd.product;

import org.example.tdd.product.model.Product;
import org.example.tdd.product.model.ProductCreateReq;
import org.example.tdd.product.model.ProductViewRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void  productService_create_success(){

        //given
        ProductCreateReq req = ProductCreateReq.builder()
                .name("이름")
                .description("설명")
                .price(1000)
                .build();
        Product product = Product.builder()
                .idx(1L)
                .name("이름")
                .description("설명")
                .price(1000)
                .build();
        given(productRepository.save(any(Product.class))).willReturn(product);

        //when
        ProductViewRes res = productService.save(req);
        //then

        assertNotNull(res);
        assertEquals(1L,res.getIdx());
        assertEquals("이름",res.getName());
        assertEquals("설명",res.getDescription());
        assertEquals(1000,res.getPrice());

    }

    @Test
    void productService_findById_success(){

        //given
        Long idx = 1L;
        Product product = Product.builder()
                .idx(1L)
                .name("이름")
                .description("설명")
                .price(1000)
                .build();
        given(productRepository.findById(any(Long.class))).willReturn(Optional.of(product));

        //when
        ProductViewRes res = productService.findById(idx);
        //then
        assertNotNull(res);
        assertEquals(1L,res.getIdx());
        assertEquals("이름",res.getName());
        assertEquals("설명",res.getDescription());
        assertEquals(1000,res.getPrice());
    }

}