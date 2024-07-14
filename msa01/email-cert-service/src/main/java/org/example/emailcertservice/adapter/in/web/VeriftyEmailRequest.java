package org.example.emailcertservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class VeriftyEmailRequest {
    private String email;
    private String uuid;
}
