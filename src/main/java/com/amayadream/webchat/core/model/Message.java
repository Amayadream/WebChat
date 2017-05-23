package com.amayadream.webchat.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 消息
 * @author : Amayadream
 * @date :   2017-05-23 09:49
 */
public class Message implements Serializable {

    /* 消息主键 */
    private Long id;
    /* 发送者 */
    private String sender;
    /* 接收者 */
    private String receiver;
    /* 正文 */
    private String content;
    /* 发送时间 */
    private LocalDateTime sendTime;

    public Message() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime;
    }

}
