package com.raf.emailservice;

import com.raf.emailservice.configuration.EmailConfiguration;
import com.raf.emailservice.domain.Tip;
import com.raf.emailservice.domain.Tipovi;
import com.raf.emailservice.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailServiceApplication {

    public static Tipovi tipovi = new Tipovi();
    public static EmailService mailing = new EmailService(new EmailConfiguration().mailSender());

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

}
