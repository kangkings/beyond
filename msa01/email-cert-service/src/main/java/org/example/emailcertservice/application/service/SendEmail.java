package org.example.emailcertservice.application.service;

import lombok.RequiredArgsConstructor;
import org.example.emailcertservice.application.port.in.SendEmailCommand;
import org.example.emailcertservice.application.port.in.SendEmailUseCase;
import org.example.emailcertservice.application.port.out.EmailCertPort;
import org.example.emailcertservice.application.port.out.SendEmailPort;
import org.example.emailcertservice.common.UseCase;


@UseCase
@RequiredArgsConstructor
public class SendEmail implements SendEmailUseCase {
    private final EmailCertPort persistencePort;
    private final SendEmailPort sendEmailPort;

    @Override
    public void sendEmail(SendEmailCommand command) {
        String uuid = persistencePort.emailCert(command.getEmail());
        sendEmailPort.sendEmail(command.getEmail(), uuid);

    }
}
