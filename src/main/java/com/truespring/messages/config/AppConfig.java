package com.truespring.messages.config;

import com.truespring.messages.app.MessageRepository;
import com.truespring.messages.app.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.truespring.messages.app")
public class AppConfig {

    @Bean
    public MessageRepository messageRepository() {
        return new MessageRepository();
    }

    @Bean
    MessageService messageService() {
        return new MessageService(messageRepository());
    }
}
