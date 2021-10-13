package com.truespring.messages.app.controller;

import com.truespring.messages.app.domain.Message;
import com.truespring.messages.app.domain.MessageData;
import com.truespring.messages.app.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1")
public class MessageController {

    private MessageService messageService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, Welcome to String Boot!";
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data) {
        log.info(">> MessageData Text :: {}", data.getText());
        Message saved = messageService.save(data.getText());
        if (saved == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(saved);
    }
}
