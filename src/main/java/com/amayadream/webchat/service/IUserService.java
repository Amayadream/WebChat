package com.amayadream.webchat.service;

import com.amayadream.webchat.pojo.User;

import java.util.List;

/**
 * NAME   :  WebChat/com.amayadream.webchat.service
 * Author :  Amayadream
 * Date   :  2016.01.08 14:36
 * TODO   :
 */
public interface IUserService {
    List<User> selectAll(int page, int pageSize);
    User selectUserByUserid(String userid);
    int selectCount(int pageSize);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userid);
}
