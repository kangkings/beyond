package org.example.memberservice.application.port.out.persistence;

import org.example.memberservice.domain.Member;

public interface SignupMemberPort {
    void saveMember(Member member);
}
