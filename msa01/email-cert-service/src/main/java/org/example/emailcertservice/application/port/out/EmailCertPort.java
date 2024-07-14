package org.example.emailcertservice.application.port.out;

import org.example.emailcertservice.domain.EmailCert;

public interface EmailCertPort {
    String emailCert(String email);

    Boolean verifyEmail(EmailCert emailCert);
}
