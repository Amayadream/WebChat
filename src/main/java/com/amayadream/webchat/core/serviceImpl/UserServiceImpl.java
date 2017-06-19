package com.amayadream.webchat.core.serviceImpl;

import com.amayadream.webchat.core.dao.IUserDao;
import com.amayadream.webchat.core.model.User;
import com.amayadream.webchat.core.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectByPrimaryKey(String userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

}
