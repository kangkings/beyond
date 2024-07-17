package org.example.memberservice.adapter.out.persistence.member;

import lombok.RequiredArgsConstructor;
import org.example.memberservice.application.port.out.persistence.SignupMemberPort;
import org.example.memberservice.common.PersistenceAdapter;
import org.example.memberservice.domain.Member;


@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements SignupMemberPort {
    private  final MemberRepository memberRepository;


    @Override
    public void saveMember(Member member) {
        MemberEntity entity = MemberEntity.builder()
                .email(member.getEmail())
                .name(member.getName())
                .build();
        memberRepository.save(entity);
        //DB 저장 코드
    }

}
