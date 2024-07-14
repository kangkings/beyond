package org.example.emailcertservice.application.port.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendEmailCommand {

    private String email;
}
