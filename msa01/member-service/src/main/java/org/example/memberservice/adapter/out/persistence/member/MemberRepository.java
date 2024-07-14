package org.example.memberservice.adapter.out.persistence.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    MemberEntity findByEmail(String email);
}
