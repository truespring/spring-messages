package com.truespring.messages.app;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageService {
    private MessageRepository messageRepository;

    public void save(String text) {
        this.messageRepository.saveMessage(new Message(text));
    }
}
