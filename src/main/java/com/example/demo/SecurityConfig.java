package com.example.demo;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
 
    private UserDetailsService userDetailsService;
    
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth->{
        auth.requestMatchers("/books").authenticated();
        auth.requestMatchers("/login").permitAll();
        auth.requestMatchers("/members").permitAll();
        auth.requestMatchers(HttpMethod.DELETE,"/book/**").hasRole("ADMIN");
        auth.anyRequest().authenticated();
       });
        http.userDetailsService(userDetailsService);
        return http.build();
    }
    @Bean 
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
        return config.getAuthenticationManager();
    }
    
    }
    


