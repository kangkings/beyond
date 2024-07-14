package org.example.emailcertservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailCertRepository extends JpaRepository<EmailCertEntity,Long> {
    Optional<EmailCertEntity> findByEmailAndUuid(String email, String uuid);
}
