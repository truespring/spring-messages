package com.truespring.messages.app.service;

import com.truespring.messages.app.domain.Message;
import com.truespring.messages.app.domain.repository.MessageRepository;
import com.truespring.messages.secure.SecurityCheck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@AllArgsConstructor
public class MessageService {
    private MessageRepository messageRepository;

    @SecurityCheck
    @Transactional(noRollbackFor = {UnsupportedOperationException.class})
    public Message save(String text) {
        Message message = messageRepository.saveMessage(new Message(text));
        log.debug("New Message[id={}] saved", message.getId());
        updateStatistics();
        return message;
    }

    private void updateStatistics() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}
