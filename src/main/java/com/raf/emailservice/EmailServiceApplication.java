package com.raf.emailservice;

import com.raf.emailservice.tipizacija.Tip;
import com.raf.emailservice.tipizacija.Tipovi;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailServiceApplication {

    public static Tipovi tipovi = new Tipovi();

    public static void main(String[] args) {
        //SpringApplication.run(EmailServiceApplication.class, args);

        Tip a = new Tip("Tip1","Tip1 %haha",1);
        String[] x = new String[1];
        x[0] = "ada";
        System.out.println(a.buildMessage(x));
        x[0] = "dad";
        System.out.println(a.buildMessage(x));
        x[0] = "waw";
        System.out.println(a.buildMessage(x));
        x[0] = "awa";
        System.out.println(a.buildMessage(x));
        Tip b = new Tip("Tip2","Tip2 %haha",1);
        Tip c = new Tip("Tip3","Tip3 %haha",1);
        EmailServiceApplication.tipovi.deleteTip("Tip2");
        System.out.println(tipovi);
    }

}
