package com.raf.emailservice.scheduler;

import com.raf.emailservice.EmailServiceApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReservationNotifierScheduler {

    @Scheduled(fixedDelay = 1000, initialDelay = 10000)
    public void  notifyAllIncomingReservations(){
        EmailServiceApplication.tipovi.getTipovi().forEach(x -> {
            System.out.println(x);
        });
    }

}
