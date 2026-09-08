package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Passport;
import com.example.demo.repository.PassportRepository;

@Service
public class PassportService {

    private PassportRepository passportrepo;

    public PassportService(PassportRepository passportrepo) {
        this.passportrepo = passportrepo;
    }

    public Passport addPassport(Passport pass) {
        return passportrepo.save(pass);
    }
}