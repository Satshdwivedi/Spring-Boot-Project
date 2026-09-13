package com.example.demo.service;



import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PassportRepository;
import com.example.demo.model.Passport;

@Service 
public class MemberService {
    private MemberRepository memberrepo;
     private PassportRepository passportrepo;
     private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberrepo, PassportRepository passportrepo,
            PasswordEncoder passwordEncoder) {
        this.memberrepo = memberrepo;
        this.passportrepo = passportrepo;
        this.passwordEncoder = passwordEncoder;
    }
   
    public Member addMember(Member mem) {
        Passport pass=passportrepo.findById(mem.getPassport().getId()).orElse(null);
        mem.setPassport(pass);
        mem.setPassword(passwordEncoder.encode(mem.getPassword()));
        mem.setRole("USER");
        return memberrepo.save(mem);
    }
    public Member getMemberById(int id){
        return memberrepo.findById(id).orElse(null);
        }

    public List<Member> getAllMembers() {
        return memberrepo.findAll();
    }
   
}
