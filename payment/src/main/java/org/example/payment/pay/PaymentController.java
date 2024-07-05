package org.example.payment.pay;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    @GetMapping("/check")
    public ResponseEntity<String> check(String impUid){
        System.out.println(impUid);
        String token = paymentService.getToken(impUid);
        Map<String, Object> info = paymentService.getPayInfo(token, impUid);
        Integer amount = paymentService.checkOrderIsValid(info);
        if(amount == -100){
            paymentService.refund(impUid, token, amount);
            return ResponseEntity.ok("fail");
        }

        return ResponseEntity.ok("ok");
    }
}
