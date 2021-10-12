package com.truespring.messages.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;


@Getter
@AllArgsConstructor
public class Message {
    private Integer id;
    private String text;
    private Date createdDate;

    public Message(String text) {
        this.text = text;
        this.createdDate = new Date();
    }
    // equals()와 hashCode()는 생략됨
}
