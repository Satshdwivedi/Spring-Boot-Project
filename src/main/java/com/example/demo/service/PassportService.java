package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Passport;
import com.example.demo.repository.PassportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PassportService {

    private final PassportRepository passportrepo;

    public Passport addPassport(Passport pass) {
        return passportrepo.save(pass);
    }
}