package org.example.tddbackend.member;

import lombok.RequiredArgsConstructor;
import org.example.tddbackend.member.model.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public MemberCreateRes create(MemberCreateReq req) {
        MemberCreateRes res = memberRepository.save(req.toMember(bCryptPasswordEncoder.encode(req.getPassword()))).toMemberCreateRes();
        return res;
    }

    public MemberReadRes read(Long idx) {

        Optional<Member> sqlRes = memberRepository.findById(idx);
        if (sqlRes.isEmpty()){
            return null;
        }
        return sqlRes.get().toMemberReadRes();
    }

    public List<MemberReadRes> readAll(){
        List<Member> sqlRes = memberRepository.findAll();
        List<MemberReadRes> res = new ArrayList<>();
        for (Member m : sqlRes){
            res.add(m.toMemberReadRes());
        }

        return res;
    }

    public PostLoginRes login(PostLoginReq req) {
        Optional<Member> member = memberRepository.findByEmail(req.getEmail());
        if (member.isPresent()){
            return member.get().toPostLoginRes();
        }else {
            return null;
        }

    }
}
