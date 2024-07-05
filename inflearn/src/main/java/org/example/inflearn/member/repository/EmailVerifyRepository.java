package org.example.inflearn.member.repository;

import org.example.inflearn.member.model.EmailVerify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailVerifyRepository extends JpaRepository<EmailVerify,Long> {
    Optional<EmailVerify> findByUuid(String uuid);
}
