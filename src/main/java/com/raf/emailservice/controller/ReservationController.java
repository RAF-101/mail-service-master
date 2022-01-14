package com.raf.emailservice.controller;

import com.raf.emailservice.EmailServiceApplication;
import com.raf.emailservice.domain.Tip;
import com.raf.emailservice.repository.TipRepository;
import com.raf.emailservice.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/notification")
public class ReservationController {

    private TipRepository tipRepository;

    public ReservationController(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/findTip/{name}")
    public ResponseEntity<String> hello(@PathVariable("name") String name) {
        return new ResponseEntity<>( EmailServiceApplication.tipovi.getTip(name).toString(), HttpStatus.OK);
    }

    @PostMapping("/addTip")
    public ResponseEntity<Void> addTip(@RequestBody @Valid Tip tip) {
        if(EmailServiceApplication.tipovi.addTip(tip)) return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping("/deleteTip")
    public ResponseEntity<Void> deleteTip(@RequestBody @Valid String name) {
        if(EmailServiceApplication.tipovi.deleteTip(name)) return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/sendNotification")
    public ResponseEntity<Void> sendNotification(@RequestBody @Valid String name, String[] parameters, String receiver) {
        Tip notification = null;
        if( (notification = EmailServiceApplication.tipovi.getTip(name) ) != null) {
            String message = notification.buildMessage(parameters);
            EmailServiceApplication.mailing.sendSimpleMessage(receiver, name, message);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
