package com.amayadream.webchat.web.vo;

import com.amayadream.webchat.core.model.Relation;
import com.amayadream.webchat.core.model.User;

import java.io.Serializable;

/**
 * @author :  Amayadream
 * @date :  2017.06.19 23:39
 */
public class UserVo implements Serializable {

    private String id;
    private String username;
    private String avatar;
    private String sign;
    /* offline/online */
    private String status;


    public static UserVo convertToVo(Relation relation) {
        UserVo vo = new UserVo();
        if (relation != null) {
            vo.setId(relation.getFriend());
            vo.setUsername(relation.getNickName());
            vo.setAvatar(relation.getAvatar());
            vo.setSign(relation.getSign());
            vo.setStatus("online");
        }
        return vo;
    }

    public static UserVo convert(User user) {
        UserVo vo = new UserVo();
        if (user != null) {
            vo.setId(user.getUserId());
            vo.setUsername(user.getNickName());
            vo.setAvatar(user.getAvatar());
            vo.setSign(user.getSign());
            vo.setStatus("online");
        }
        return vo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
