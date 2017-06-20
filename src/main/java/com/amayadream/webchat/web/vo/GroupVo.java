package com.amayadream.webchat.web.vo;

import com.amayadream.webchat.core.model.Group;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.06.19 23:37
 */
public class GroupVo implements Serializable {

    private Long id;
    private String groupname;
    private String avatar;

    /**
     * group -> groupVo
     */
    public static GroupVo convertToVo(Group group) {
        GroupVo vo = new GroupVo();
        if (group != null) {
            vo.setId(group.getId());
            vo.setGroupname(group.getName());
            vo.setAvatar(group.getAvatar());
        }
        return vo;
    }

    /**
     * groups -> groupVos
     */
    public static List<GroupVo> convertToVos(List<Group> groups) {
        List<GroupVo> vos = new ArrayList<GroupVo>();
        if (!CollectionUtils.isEmpty(groups)) {
            groups.forEach((item)->vos.add(convertToVo(item)));
        }
        return vos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
