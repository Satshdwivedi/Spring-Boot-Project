package com.example.demo;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.JwtFilter;

import jakarta.servlet.http.HttpServletResponse;


@Configuration
public class SecurityConfig {
 
    private UserDetailsService userDetailsService;
    private JwtFilter jwtFilter;
    
    public SecurityConfig(UserDetailsService userDetailsService, JwtFilter jwtFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtFilter = jwtFilter;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth->{
        auth.requestMatchers("/login").permitAll();
        auth.requestMatchers("/members").permitAll();
        auth.requestMatchers("/decode").permitAll();
        auth.requestMatchers("/encode").permitAll();
        auth.requestMatchers(HttpMethod.DELETE,"/book/**").hasRole("ADMIN");
        auth.anyRequest().authenticated();
       });
        http.userDetailsService(userDetailsService);
        http.exceptionHandling(exception ->
        exception.authenticationEntryPoint((request, response, authException) ->
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED) ));
        http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
    @Bean 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
        return config.getAuthenticationManager();
    }
    
    }
    


