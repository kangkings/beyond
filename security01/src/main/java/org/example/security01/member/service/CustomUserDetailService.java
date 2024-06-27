package org.example.security01.member.service;

import lombok.RequiredArgsConstructor;
import org.example.security01.member.model.CustomUserDetails;
import org.example.security01.member.model.Member;
import org.example.security01.member.reposiroty.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username).orElseThrow();
        return new CustomUserDetails(member);
    }
}
