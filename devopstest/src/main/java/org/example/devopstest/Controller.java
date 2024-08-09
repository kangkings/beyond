package org.example.devopstest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/version")
    public String version(){
        System.out.println("푸시테스트~~~");
        System.out.println("푸시테스트~git ~~");
        return "v1";
    }
}
