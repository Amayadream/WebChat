package com.amayadream.webchat.web.vo;

import com.amayadream.webchat.core.model.GroupMember;
import com.amayadream.webchat.core.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.06.19 23:26
 */
public class MemberVo implements Serializable {

    private String id;
    private String username;
    private String avatar;
    private String sign;

    public static List<MemberVo> convert(List<GroupMember> members) {
        List<MemberVo> vos = new ArrayList<MemberVo>();
        if (members == null || members.size() == 0) {
            return vos;
        }
        members.forEach((item) -> vos.add(convert(item)));
        return vos;
    }

    public static MemberVo convert(GroupMember member) {
        MemberVo vo = new MemberVo();
        vo.setId(member.getMember());
        vo.setUsername(member.getNickName());
        vo.setAvatar(member.getAvatar());
        vo.setSign(member.getSign());
        return vo;
    }

    public static MemberVo convert(User user) {
        MemberVo vo = new MemberVo();
        vo.setId(user.getUserId());
        vo.setUsername(user.getNickName());
        vo.setAvatar(user.getAvatar());
        vo.setSign(user.getSign());
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
}
