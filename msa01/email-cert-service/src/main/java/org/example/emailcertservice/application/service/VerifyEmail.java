package org.example.emailcertservice.application.service;

import lombok.RequiredArgsConstructor;
import org.example.emailcertservice.application.port.in.VerifyEmailCommand;
import org.example.emailcertservice.application.port.in.VerifyEmailUseCase;
import org.example.emailcertservice.application.port.out.EmailCertPort;
import org.example.emailcertservice.common.UseCase;
import org.example.emailcertservice.domain.EmailCert;

@UseCase
@RequiredArgsConstructor
public class VerifyEmail implements VerifyEmailUseCase {
    private final EmailCertPort persistencePort;

    @Override
    public Boolean verifyEmail(VerifyEmailCommand command) {
        EmailCert emailCert = EmailCert.builder()
                .email(command.getEmail())
                .uuid(command.getUuid())
                .build();
        return persistencePort.verifyEmail(emailCert);
    }
}
