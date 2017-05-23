package com.amayadream.webchat.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 群组成员
 * @author : Amayadream
 * @date :   2017-05-23 11:51
 */
public class GroupMember implements Serializable {

    /* 群组id */
    private Long groupId;
    /* 成员名称 */
    private String member;
    /* 加入时间 */
    private LocalDateTime createdTime;
    /* 加入状态, 0:待审核, 1:正常 */
    private int status;

    public GroupMember() {

    }

    public GroupMember(Long groupId, String member, LocalDateTime createdTime, int status) {
        this.groupId = groupId;
        this.member = member;
        this.createdTime = createdTime;
        this.status = status;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
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
