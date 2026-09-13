package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.CustomUserDetails;
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private MemberRepository memberre;
  
    public CustomUserDetailsService(MemberRepository memberre) {
        this.memberre = memberre;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Member member=memberre.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(member);
    }

}
