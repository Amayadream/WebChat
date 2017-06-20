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
    private String groupName;
    /* 添加时间 */
    private LocalDateTime createdTime;
    /* 状态, 0:待同意, 1:同意, -1:拒绝 */
    private int status;


    /* 附加属性 */
    private String nickName;
    private String avatar;
    private String sign;

    public Relation() {

    }

    public Relation(String userId) {
        this.userId = userId;
    }

    public Relation(String userId, String friend, String groupName, LocalDateTime createdTime, int status) {
        this.userId = userId;
        this.friend = friend;
        this.groupName = groupName;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
