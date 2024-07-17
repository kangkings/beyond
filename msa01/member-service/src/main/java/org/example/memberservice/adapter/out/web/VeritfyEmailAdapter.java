package org.example.memberservice.adapter.out.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VeritfyEmailAdapter {
    private final OpenFeignVerifyEmailCertClient feignClient;

    public Boolean verifyEmailCert(String email, String uuid){
        return feignClient.call(email,uuid);
    }
}
