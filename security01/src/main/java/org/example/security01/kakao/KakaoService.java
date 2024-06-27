package org.example.kakao.member;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class KakaoService {

    public String getKakaoToken(String code){
        //API 문서에서 정의한대로 요청 헤더 작성
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded;charset=utf-8");
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", "6d9bcc3b9da7d326d1a35be9e4cf9f36");
        body.add("redirect_uri","http://localhost:8080/kakao/redirect");
        body.add("code", code);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(body,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                request,
                String.class);


        Gson gson = new Gson();
        Map<String,Object> res = gson.fromJson(response.getBody(), Map.class);
        return""+res.get("access_token");

    }

    public String getUserInfo(String accessToken){
        //API 문서에서 정의한대로 요청 헤더 작성
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded;charset=utf-8");
        headers.add(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("https://kapi.kakao.com/v2/user/me",
                HttpMethod.GET,
                request,
                String.class);


        Gson gson = new Gson();
        Map<String,Object> res = gson.fromJson(response.getBody(), Map.class);

        Double id = (double)res.get("id");
        System.out.println(id.longValue());

        Map<String, Object> properties = (Map<String,Object>)res.get("properties");
        String nickname = ""+properties.get("nickname");
        return request.toString();
    }
}
