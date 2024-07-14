package org.example.emailcertservice.application.port.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VerifyEmailCommand {
    private String email;
    private String uuid;
}
