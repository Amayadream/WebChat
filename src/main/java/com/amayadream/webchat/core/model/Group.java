package com.amayadream.webchat.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 群组
 * @author : Amayadream
 * @date :   2017-05-23 11:33
 */
public class Group implements Serializable {

    /* 主键id */
    private Long id;
    /* 群组名称 */
    private String name;
    /* 描述 */
    private String desc;
    /* 群组头像 */
    private String avatar;
    /* 管理员/创建者 */
    private String userId;
    /* 创建时间 */
    private LocalDateTime createdTime;

    /* 附加字段 */
    /* 加入者 */
    private String member;

    public Group() {

    }

    public Group(String member) {
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

}
