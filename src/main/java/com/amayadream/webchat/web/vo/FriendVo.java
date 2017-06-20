package com.amayadream.webchat.web.vo;

import com.amayadream.webchat.core.model.Relation;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  Amayadream
 * @date :  2017.06.20 22:45
 */
public class FriendVo implements Serializable {

    private Integer id;
    private String groupname;
    private Integer online;
    private List<UserVo> list;

    /**
     * relations -> friendVos
     */
    public static List<FriendVo> convertToVo(List<Relation> relations) {
        List<FriendVo> vos = new ArrayList<FriendVo>();
        if (!CollectionUtils.isEmpty(relations)) {
            //1.遍历获取所有的分组
            Set<String> set = new HashSet<String>();
            relations.forEach((item) -> set.add(item.getGroupName()));
            //2.按照分组构建
            set.forEach((groupName) -> {
                FriendVo vo = new FriendVo();
                vo.setId(1);
                vo.setGroupname(groupName);
                vo.setOnline(0);
                List<UserVo> userVos = new ArrayList<UserVo>();
                relations.forEach((relation -> {
                    if (groupName.equals(relation.getGroupName())) {
                        userVos.add(UserVo.convertToVo(relation));
                    }
                }));
                vo.setList(userVos);
                vos.add(vo);
            });
        }
        return vos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public List<UserVo> getList() {
        return list;
    }

    public void setList(List<UserVo> list) {
        this.list = list;
    }
}
