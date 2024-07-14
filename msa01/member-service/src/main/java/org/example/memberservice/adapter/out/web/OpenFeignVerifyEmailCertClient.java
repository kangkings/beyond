package org.example.memberservice.adapter.out.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient(name = "EmailCert", url="http://localhost:8082/emailcert/verify")
public interface OpenFeignVerifyEmailCertClient {
    @GetMapping
    Boolean call(@RequestParam String email , @RequestPart String uuid);
}
