package com.myspringboot.controller;

import com.myspringboot.service.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private JmsService jmsService;

    @GetMapping("/")
    public String app() {
        return "welcome to myspringboot";
    }

    @GetMapping("send")
    public String send(@RequestParam String message) {
        return jmsService.send(message);
    }

    @GetMapping("receive")
    public String receive() {
        return jmsService.receive();
    }

    @GetMapping("address")
    public String address() {
        return jmsService.address();
    }

}
