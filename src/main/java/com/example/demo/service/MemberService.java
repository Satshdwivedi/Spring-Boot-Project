package com.example.demo.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PassportRepository;
import com.example.demo.model.Passport;

@Service 
public class MemberService {
    private MemberRepository memberrepo;
     private PassportRepository passportrepo;

    public MemberService(MemberRepository memberrepo, PassportRepository passportrepo) {
        this.memberrepo = memberrepo;
        this.passportrepo = passportrepo;
    }
   
    public Member addMember(Member mem) {
        Passport pass=passportrepo.findById(mem.getPassport().getId()).orElse(null);
        mem.setPassport(pass);
        return memberrepo.save(mem);
    }
    public Member getMemberById(int id){
        return memberrepo.findById(id).orElse(null);
        }

    public List<Member> getAllMembers() {
        return memberrepo.findAll();
    }
   
}
