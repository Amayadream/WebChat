package com.amayadream.webchat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.amayadream.webchat.common.result.ResultConstant;
import com.amayadream.webchat.common.result.Results;
import com.amayadream.webchat.common.util.Constants;
import com.amayadream.webchat.core.model.Group;
import com.amayadream.webchat.core.model.GroupMember;
import com.amayadream.webchat.core.model.Relation;
import com.amayadream.webchat.core.model.User;
import com.amayadream.webchat.core.service.GroupMemberService;
import com.amayadream.webchat.core.service.GroupService;
import com.amayadream.webchat.core.service.RelationService;
import com.amayadream.webchat.web.vo.FriendVo;
import com.amayadream.webchat.web.vo.GroupVo;
import com.amayadream.webchat.web.vo.MemberVo;
import com.amayadream.webchat.web.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2017.06.20 22:23
 */
@RestController
@RequestMapping(value = "")
@SessionAttributes({Constants.SESSION_USERID, Constants.SESSION_USER})
public class ChatController {

    @Resource
    private GroupService groupService;
    @Resource
    private GroupMemberService groupMemberService;
    @Resource
    private RelationService relationService;

    /**
     * 获取好友列表/个人信息/群组列表
     */
    @RequestMapping(value = "/friends", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Results friend(@ModelAttribute(Constants.SESSION_USERID) String userId, @ModelAttribute(Constants.SESSION_USER) User user) {
        List<Group> groups = groupService.list(new Group(userId));
        List<Relation> relations = relationService.list(new Relation(userId));
        JSONObject data = new JSONObject();
        data.put("group", GroupVo.convertToVos(groups));
        data.put("mine", UserVo.convert(user));
        data.put("friend", FriendVo.convertToVo(relations));
        return Results.ok(ResultConstant.SUCCESS, data);
    }

    /**
     * 获取指定群的群成员列表
     */
    @RequestMapping(value = "/members", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Results members(@ModelAttribute(Constants.SESSION_USERID) String userId, @ModelAttribute(Constants.SESSION_USER) User user, @RequestParam Long groupId) {
        List<GroupMember> list = groupMemberService.list(groupId);
        JSONObject data = new JSONObject();
        data.put("owner", MemberVo.convertToVo(user));
        data.put("members", list.size());
        data.put("list", MemberVo.convertToVos(list));
        return Results.ok(ResultConstant.SUCCESS, data);
    }

}
