package com.barosanu.controller.services;

import com.barosanu.EmailManager;
import com.barosanu.controller.EmailLoginResult;
import com.barosanu.model.EmailAccount;

public class LoginService {

    EmailAccount emailAccount;
    EmailManager emailManager;

    public LoginService(EmailAccount emailAccount, EmailManager emailManager) {
        this.emailAccount = emailAccount;
        this.emailManager = emailManager;
    }

    public EmailLoginResult login(){

    }
}
