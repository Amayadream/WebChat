package com.amayadream.webchat.core.serviceImpl;

import com.amayadream.webchat.core.dao.IGroupMemberDao;
import com.amayadream.webchat.core.model.GroupMember;
import com.amayadream.webchat.core.service.GroupMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:22
 */
@Service
public class GroupMemberServiceImpl implements GroupMemberService {

    @Resource
    private IGroupMemberDao groupMemberDao;

    @Override
    public List<GroupMember> list(Long groupId) {
        return groupMemberDao.list(groupId);
    }
}
