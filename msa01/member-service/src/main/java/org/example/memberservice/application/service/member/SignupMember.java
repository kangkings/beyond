package org.example.memberservice.application.service.member;

import lombok.RequiredArgsConstructor;
import org.example.memberservice.application.port.in.member.SignupMemberCommand;
import org.example.memberservice.application.port.in.member.SignupMemberUseCase;
import org.example.memberservice.application.port.out.kafka.SignupMemberNotificationPort;
import org.example.memberservice.application.port.out.persistence.SignupMemberPort;
import org.example.memberservice.common.UseCase;
import org.example.memberservice.domain.Member;

@UseCase
@RequiredArgsConstructor
public class SignupMember implements SignupMemberUseCase {
    private final SignupMemberPort persistencePort;
    private final SignupMemberNotificationPort kafkaPort;

    @Override
    public void sigunupMember(SignupMemberCommand command) {
        //출력 포트로 데이터 보내기
        Member member = Member.builder()
                .email(command.getEmail())
                .name(command.getName())
                .build();
        persistencePort.saveMember(member);
        kafkaPort.sendSignupMessage(member.getEmail());
    }
}
