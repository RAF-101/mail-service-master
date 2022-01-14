package com.raf.emailservice.controller;

import com.raf.emailservice.domain.Tip;
import com.raf.emailservice.repository.TipRepository;
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
@RequestMapping("/reservation")
public class ReservationController {

    private TipRepository tipRepository;

    public ReservationController(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> hello(@PathVariable("name") String name) {
        return new ResponseEntity<>( tipRepository.findByName(name).toString(), HttpStatus.OK);
    }

    @PostMapping("/tip")
    public ResponseEntity<Void> addTip(@RequestBody @Valid Tip tip) {
        tipRepository.save(tip);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
