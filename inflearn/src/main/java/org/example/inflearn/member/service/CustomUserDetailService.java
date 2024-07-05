package org.example.inflearn.member.service;

import lombok.RequiredArgsConstructor;
import org.example.inflearn.member.model.CustomUserDetails;
import org.example.inflearn.member.model.Member;
import org.example.inflearn.member.repository.MemberRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByEmail(username);
        if (member.isPresent()){
            return new CustomUserDetails(member.get());
        }else {
            return null;
        }

    }
}
