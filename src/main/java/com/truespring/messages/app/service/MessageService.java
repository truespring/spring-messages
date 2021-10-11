package com.truespring.messages.app.service;

import com.truespring.messages.app.domain.Message;
import com.truespring.messages.app.domain.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageService {
    private MessageRepository messageRepository;

    public void save(String text) {
        this.messageRepository.saveMessage(new Message(text));
    }
}
