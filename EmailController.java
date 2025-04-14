package com.example.EmailServiceController.Controller;


import com.example.EmailServiceController.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmailServiceController.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

//    @PostMapping("/send")
//    public String sendMail() {
//
//        String to = "realperson@gmail.com";
//        String subject = "Hello from My Spring App!";
//        String body = "Hey! This is a test email sent via Spring Boot using Gmail SMTP.";
//
//        emailService.sendEmail(to, subject, body);
//        return "Email sent successfully!";

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return "Email sent successfully!";
    }
}
