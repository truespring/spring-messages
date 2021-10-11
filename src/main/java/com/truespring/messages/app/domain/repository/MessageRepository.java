package com.truespring.messages.app.domain.repository;

import com.truespring.messages.app.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageRepository {

    public void saveMessage(Message message) {
        // 데이터베이스에 메시지를 저장한다
        log.info(">> Saved message: {}", message.getText());
    }
}
