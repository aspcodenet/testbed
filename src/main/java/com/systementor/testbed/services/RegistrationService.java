package com.systementor.testbed.services;

import org.springframework.stereotype.Service;

import com.systementor.testbed.services.model.UserAccount;

@Service
public class RegistrationService {
    private UserRepository repository;
    private EmailSenderService emailSenderService;

    public RegistrationService(UserRepository repository, EmailSenderService emailSenderService) {
        super();
        this.repository = repository;
        this.emailSenderService = emailSenderService;
    }
    public enum RegisterStatus{
        Ok,
        WrongDomain,
        AlreadyExisting
    }
    public RegisterStatus Register(String email, String name ){
        if (!email.endsWith("@systementor.se")) return RegisterStatus.WrongDomain;
        var account = getAccount(email);
        if(account != null) return RegisterStatus.AlreadyExisting;

        account = new UserAccount();
        account.setEmail(email);
        account.setName(name);
        repository.save(account);
        
        emailSenderService.SendEmail(email,name,"Registration","Thanks for becoming a member");

        return RegisterStatus.Ok;
    }
    private UserAccount getAccount(String email) {
        return  repository.findByEmail(email);
    }
}
