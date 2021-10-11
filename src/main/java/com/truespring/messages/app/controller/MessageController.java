package com.truespring.messages.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, Welcome to String Boot!";
    }
}
