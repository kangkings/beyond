package org.example.spring_day01.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(method = RequestMethod.GET, value = "/ex01")
    public String ex01(Model model){
        model.addAttribute("message","아아아아");
        return "test";
    }
}
