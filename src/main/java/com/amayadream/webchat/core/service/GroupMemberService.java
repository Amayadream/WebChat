package com.amayadream.webchat.core.service;

import com.amayadream.webchat.core.model.GroupMember;

import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:20
 */
public interface GroupMemberService {

    List<GroupMember> list(Long groupId);

}
