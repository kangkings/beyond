package org.example.day0704.test;

import jakarta.validation.Valid;
import org.example.day0704.test.model.RequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;


@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/ex01")
    public ResponseEntity<String> ex01(
           @RequestBody RequestDTO request
    ){
        return ResponseEntity.ok("ex01");
    }

    @GetMapping("/ex02")
    public ResponseEntity<String> ex02(
            @Valid RequestDTO requestDTO
    ){
        return ResponseEntity.ok("ex02");
    }
}
