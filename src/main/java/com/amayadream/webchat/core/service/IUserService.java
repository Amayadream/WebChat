package com.amayadream.webchat.core.service;

import com.amayadream.webchat.core.model.User;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:19
 */
public interface IUserService {

    User selectByPrimaryKey(String userId);

    int insert(User user);

    int update(User user);

}
