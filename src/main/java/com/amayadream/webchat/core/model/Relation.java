package com.amayadream.webchat.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户关联表
 * @author : Amayadream
 * @date :   2017-05-23 10:06
 */
public class Relation implements Serializable {

    /* 用户名 */
    private String userId;
    /* 关联用户名 */
    private String friend;
    /* 分组名称 */
    private String group;
    /* 添加时间 */
    private LocalDateTime createdTime;
    /* 状态, 0:待同意, 1:同意, -1:拒绝 */
    private int status;

    public Relation() {

    }

    public Relation(String userId, String friend, String group, LocalDateTime createdTime, int status) {
        this.userId = userId;
        this.friend = friend;
        this.group = group;
        this.createdTime = createdTime;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
