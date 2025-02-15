package com.myspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/")
    public String app() {
        return "welcome to myspringboot";
    }
}
