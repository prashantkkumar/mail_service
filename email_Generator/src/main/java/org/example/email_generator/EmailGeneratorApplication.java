package org.example.email_generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class EmailGeneratorApplication {
    @Autowired
    private JavaMailSender mailSender;


    public static void main(String[] args) {
        SpringApplication.run(EmailGeneratorApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("tubebute1173@gmail.com");
        message.setSubject("Welcome Message");
        message.setText("This is the default email template");
        message.setFrom("prashantoff61@gmail.com");

        mailSender.send(message);
    }

}
