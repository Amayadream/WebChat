package com.amayadream.webchat.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : Amayadream
 * @date :   2017-05-22 16:06
 */
public class User implements Serializable {

    private String userId;
    private String nickName;
    private String password;
    private String salt;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public User() {
    }

    public User(String userId, String nickName, String password, String salt, LocalDateTime createdTime) {
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
        this.salt = salt;
        this.createdTime = createdTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
