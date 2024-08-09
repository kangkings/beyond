package org.example.devopstest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/version")
    public String version(){
        return "v1";
    }
}
