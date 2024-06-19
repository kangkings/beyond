package org.example.spring_day01.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(method = RequestMethod.GET, value = "/ex01")
    public String ex01(){
        return "abcd";
    }
}
