package org.example.payment.pay;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    public String getToken(String impUid){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.add(HttpHeaders.ACCEPT, "application/json");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("imp_key", "");
        jsonObject.addProperty("imp_secret", "");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(jsonObject);


        //https://api.iamport.kr/payments/
        HttpEntity<String> request = new HttpEntity<>(jsonStr,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.exchange("https://api.iamport.kr/users/getToken",
                HttpMethod.POST,
                request,
                String.class);
        System.out.println(res.getBody());

        Gson gson1 = new Gson();
        Map<String,Object> res2 = gson1.fromJson(res.getBody(), Map.class);
        Map<String,Object> realRes = (Map)res2.get("response");
        String rrealRes = (String)realRes.get("access_token");
        System.out.println(rrealRes);

        return rrealRes;
    }

    public Map<String, Object> getPayInfo(String token, String impUid){
        // GET https://api.iamport.kr/payments/%7BimpUid%7D
        // Headers
        //  "Authorization", 위에서 받은 토큰
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, token);

        HttpEntity<String> request = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.exchange("https://api.iamport.kr/payments/"+impUid,
                HttpMethod.GET,
                request,
                String.class);
        Gson gson = new Gson();
        Map<String,Object> realRes = gson.fromJson(res.getBody(), Map.class);
        System.out.println(realRes);

        return realRes;
        // 결제 정보를 출력
    }

    public Integer checkOrderIsValid(Map<String,Object> info){
        //실제 상품의 금액과 결제 금액을 비교
        //실제 상품의 금액은 info에서 custom_data 상품 번호로 가격을 DB에서 조회하고 수량으로 계산
        //실제 결제 금액은 info에서 amount로 확인
        //두 값이 일치하면 주문 테이블에 정보 저장
        // 주문 성공이라고 출력
        //두 값이 일치하지 않으면 환불 처리
        // 결제에 문제가 발생했습니다 자동으로 환불처리 됩니다 출력
        System.out.println(info.keySet());
        List<ProductInfo> products = new ArrayList<>();
        products.add(ProductInfo.builder()
                        .p_idx(1)
                        .price(10000)
                .build());

        products.add(ProductInfo.builder()
                .p_idx(2)
                .price(30000)
                .build());

        Gson gson = new Gson();
        Map<String,Object> response = (Map)info.get("response");
        String custom_data_str = (String) response.get("custom_data");
        Map<String,Object> custom_data = gson.fromJson(custom_data_str, Map.class);
        List<Map<String,Double>> list = (List<Map<String , Double>>)custom_data.get("list");

        Double amount = (Double) response.get("amount");
        Integer calcedAmount = 0;
        for (Map<String,Double> m : list){
            for (String s : m.keySet()){
                System.out.println(products.get(Integer.parseInt(s)-1).getPrice());
                System.out.println(m.get(s).intValue());
                calcedAmount += products.get(Integer.parseInt(s)-1).getPrice()*m.get(s).intValue();
            }

        }

        if (amount.intValue() == calcedAmount){
            save(amount.intValue());
            return amount.intValue();
        }else {
            System.out.println("문제가 발생했습니다. 자동으로 환불처리 됩니다.");
            return -100;
        }

    }

    public void save(Integer amount){
        System.out.println("저장 성공! 총 결제금액: "+amount);
    }

    public void refund(String impUid, String token, Integer amount) {
        //환불 처리
        //POST https://api.iamport.kr/payments/cancel
        //Headers
        //"Content-type","application/json"
        //"Authorizaion",token
        //Body
        /*
         {
         "imp_uid": "imp_uid",
         "amount": 0,
            "reason": "reason"
         }
         */

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("imp_uid", impUid);
        jsonObject.addProperty("amount", amount);
        jsonObject.addProperty("reason", "상품총액과 실 결제금액간 불일치로 인한 환불처리");
        String body = gson.toJson(jsonObject);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE,"application/json");
        headers.add(HttpHeaders.AUTHORIZATION, token);

        HttpEntity<String> request = new HttpEntity<>(body,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("https://api.iamport.kr/payments/cancel"
                ,HttpMethod.POST
                ,request
                ,String.class
                );
        System.out.println(response);

    }
}
