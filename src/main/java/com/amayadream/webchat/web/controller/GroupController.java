package com.amayadream.webchat.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.amayadream.webchat.common.result.ResultConstant;
import com.amayadream.webchat.common.result.Results;
import com.amayadream.webchat.common.util.Constants;
import com.amayadream.webchat.core.model.GroupMember;
import com.amayadream.webchat.core.model.User;
import com.amayadream.webchat.core.service.GroupMemberService;
import com.amayadream.webchat.core.service.GroupService;
import com.amayadream.webchat.web.vo.MemberVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 13:40
 */
@RestController
@RequestMapping(value = "/group")
@SessionAttributes({Constants.SESSION_USERID, Constants.SESSION_USER})
public class GroupController {

    @Resource
    private GroupService groupService;
    @Resource
    private GroupMemberService groupMemberService;

    /**
     * 群成员列表
     */
    @RequestMapping(value = "/members", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Results members(@ModelAttribute(Constants.SESSION_USERID) String userId, @ModelAttribute(Constants.SESSION_USER) User user, @RequestParam Long groupId) {
        List<GroupMember> list = groupMemberService.list(groupId);
        JSONObject data = new JSONObject();
        data.put("owner", MemberVo.convert(user));
        data.put("members", list.size());
        data.put("list", MemberVo.convert(list));
        return Results.ok(ResultConstant.SUCCESS, data);
    }

}
