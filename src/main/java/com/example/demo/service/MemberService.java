package com.example.demo.service;



import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@Service 
public class MemberService {
    private MemberRepository memberrepo;

    public MemberService(MemberRepository memberrepo) {
        this.memberrepo = memberrepo;
    }
    public Member addMember(Member mem) {
        return memberrepo.save(mem);
    }
    public Member getMemberById(int id){
        return memberrepo.findById(id).orElse(null);
        }

}
