package com.example.freemoneynoscam.services;

public class ValidateEmailService {
    public boolean isEmailValid(String email){
        //TODO implement logic such that we verify an e-mail is valid
        boolean isEmailvalid = false;
        if (email.contains("@") && email.contains(".")) {
            isEmailvalid = true;
        }
        return isEmailvalid;
    }
}
