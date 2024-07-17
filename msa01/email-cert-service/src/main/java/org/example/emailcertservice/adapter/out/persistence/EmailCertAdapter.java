package org.example.emailcertservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.emailcertservice.application.port.out.EmailCertPort;
import org.example.emailcertservice.common.PersistenceAdapter;
import org.example.emailcertservice.domain.EmailCert;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class EmailCertAdapter implements EmailCertPort {
    private final EmailCertRepository emailCertRepository;
    @Override
    public String emailCert(String email) {
        String uuid = UUID.randomUUID().toString();
        EmailCertEntity entity = EmailCertEntity.builder()
                .uuid(uuid)
                .email(email)
                .build();
        emailCertRepository.save(entity);
        return uuid;
    }

    @Override
    public Boolean verifyEmail(EmailCert emailCert) {
        Optional<EmailCertEntity> entity = emailCertRepository.findByEmailAndUuid(emailCert.getEmail(),emailCert.getUuid());

        if (entity.isPresent()){
            return true;
        }else {

            return false;
        }
    }
}
