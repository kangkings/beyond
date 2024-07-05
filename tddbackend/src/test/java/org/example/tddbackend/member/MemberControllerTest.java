package org.example.tddbackend.member;

import org.example.tddbackend.member.model.MemberCreateReq;
import org.example.tddbackend.member.model.MemberCreateRes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MemberRepository memberRepository;
    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private MemberService memberService;

    @Test
    void memberController_create_success(){
        //given
        MemberCreateReq req = MemberCreateReq.builder()
                .email("test01@mail.com")
                .password("qwer1234")
                .build();
        MemberCreateRes serviceRes = MemberCreateRes.builder()
                .idx(1L)
                .email("test01@mail.com")
                .build();
        given(memberService.create(any(MemberCreateReq.class))).willReturn(serviceRes);

        //when
        MemberCreateRes res = memberService.create(req);

        //then
        assertNotNull(res);
        assertEquals(1L, res.getIdx());
        assertEquals("test01@mail.com", res.getEmail());

    }

}