package com.truespring.messages.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageRepository {

    public void saveMessage(Message message) {
        // 데이터베이스에 메시지를 저장한다
        log.info(">> Saved message: {}", message.getText());
    }
}
