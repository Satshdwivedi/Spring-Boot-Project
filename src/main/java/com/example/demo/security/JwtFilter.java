package com.example.demo.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
private JwtService jwtservice;
private UserDetailsService userDetailsService;
 
public JwtFilter(JwtService jwtservice, UserDetailsService userDetailsService) {
    this.jwtservice = jwtservice;
    this.userDetailsService = userDetailsService;
}

@Override 
protected void doFilterInternal(HttpServletRequest request,
    HttpServletResponse response,FilterChain filterChain)throws ServletException,IOException{
          System.out.println("JWT Filter is Running");
        String authHeader=request.getHeader("Authorization");
        if(authHeader!=null && authHeader.startsWith("Bearer ")){
            String token = authHeader.substring(7).trim();
            try{
            String email=jwtservice.extractEmail(token);
            UserDetails userDetails= userDetailsService.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken authenticationToken=
            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            System.out.println("AUTH = " + SecurityContextHolder.getContext().getAuthentication());
        }
            catch(ExpiredJwtException e){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;}
            catch(JwtException e){response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;}
        }
         filterChain.doFilter(request, response);
    }
}