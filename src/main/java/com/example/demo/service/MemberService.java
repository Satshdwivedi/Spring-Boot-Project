package com.example.demo.service;



import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.PassportRepository;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.Passport;

@Service 
@RequiredArgsConstructor 
public class MemberService {
    private final MemberRepository memberrepo;
     private final PassportRepository passportrepo;
     private final PasswordEncoder passwordEncoder;
   
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
