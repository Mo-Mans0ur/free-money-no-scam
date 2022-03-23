package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.ConnectToDB;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {
    static ValidateEmailService service = new ValidateEmailService();
    private ConnectToDB db = new ConnectToDB("jdbc:mysql://localhost:3306/fmns","root","Moha2300");

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm) {
        String email = dataFromForm.getParameter("email");

        if (service.isEmailValid(email) == true){
            db.connectionToDataBase(email);
            return "redirect:/validEmail";
        }else{
            return "redirect:/wrongEmail";
        }
    }

    @GetMapping("/wrongEmail")
    public String wrongEmail() {
        return "wrongEmail";
    }

    @GetMapping("/validEmail")
    public String validEmail() {
        return "validEmail";
    }
}
