package org.example.spring_day03.test.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/create")
    public ResponseEntity<String> create(){
        testService.create();

        return ResponseEntity.ok("생성");
    }
    @GetMapping("/read")
    public ResponseEntity<String> read(){
        testService.read();

        return ResponseEntity.ok("생성");
    }
    @GetMapping("/update")
    public ResponseEntity<String> update(){
        testService.update();

        return ResponseEntity.ok("생성");
    }
    @GetMapping("/delete")
    public ResponseEntity<String> delete(){
        testService.delete();

        return ResponseEntity.ok("생성");
    }

    @GetMapping("/readByIdx")
    public ResponseEntity<String> readByIdx(){
        testService.readByIdx();

        return ResponseEntity.ok("생성");
    }
}
