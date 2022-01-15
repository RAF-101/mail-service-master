package com.raf.emailservice;

import com.raf.emailservice.configuration.DefaultTipConfiguration;
import com.raf.emailservice.configuration.EmailConfiguration;
import com.raf.emailservice.domain.Tip;
import com.raf.emailservice.domain.Tipovi;
import com.raf.emailservice.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class EmailServiceApplication {

    public static Tipovi tipovi = new Tipovi();
    public static EmailService mailing = new EmailService(new EmailConfiguration().mailSender());

    public static void main(String[] args) {
        for(Tip tip : DefaultTipConfiguration.toAdd){EmailServiceApplication.tipovi.addTip(tip);}
        SpringApplication.run(EmailServiceApplication.class, args);
    }

}
