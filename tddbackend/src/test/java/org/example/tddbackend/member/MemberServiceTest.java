package org.example.tddbackend.member;

import org.example.tddbackend.member.model.Member;
import org.example.tddbackend.member.model.MemberCreateReq;
import org.example.tddbackend.member.model.MemberCreateRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void memberService_create_success(){
        MemberCreateReq req = MemberCreateReq.builder()
                .email("aaaa")
                .password("qwer1234")
                .build();

        Member member = Member.builder()
                .idx(1L)
                .email("a112233")
                .password("qwer1234")
                .role("ROLE_USER")
                .build();

        given(bCryptPasswordEncoder.encode(any(String.class))).willReturn("a112233");
        given(memberRepository.save(any(Member.class))).willReturn(member);

        MemberCreateRes res = memberRepository.save(req.toMember(bCryptPasswordEncoder.encode(req.getPassword()))).toMemberCreateRes();

        assertNotNull(res);
        assertEquals(1L, res.getIdx());
        assertEquals("a112233",res.getEmail());
    }


}