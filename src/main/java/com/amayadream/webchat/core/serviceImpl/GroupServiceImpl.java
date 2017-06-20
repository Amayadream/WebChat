package com.amayadream.webchat.core.serviceImpl;

import com.amayadream.webchat.core.dao.IGroupDao;
import com.amayadream.webchat.core.model.Group;
import com.amayadream.webchat.core.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:22
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Resource
    private IGroupDao groupDao;

    @Override
    public Group selectByPrimaryKey(Long id) {
        return groupDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Group> list(Group group) {
        return groupDao.list(group);
    }
}
