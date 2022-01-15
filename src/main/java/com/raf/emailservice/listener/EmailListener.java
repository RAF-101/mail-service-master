package com.raf.emailservice.listener;

import com.raf.emailservice.dto.TipDto;
import com.raf.emailservice.listener.helper.MessageHelper;
import com.raf.emailservice.listener.helper.MessageHelper;
import com.raf.emailservice.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class EmailListener {

    private MessageHelper messageHelper;
    private EmailService emailService;

    public EmailListener(MessageHelper messageHelper, EmailService emailService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
    }

    @JmsListener(destination = "${destination.sendEmails}", concurrency = "5-10")
    public void sentNotification(Message message) throws JMSException {
        //TipDto tipDto = messageHelper.getMessage(message, TipDto.class);
        System.out.println(message);
        //emailService.sendSimpleMessage("mradovic01011111@gmail.com", "subject", tipDto.toString());
    }
}
