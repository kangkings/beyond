package org.example.emailcertservice.application.port.in;

public interface VerifyEmailUseCase {
    Boolean verifyEmail(VerifyEmailCommand command);
}
