package com.amayadream.webchat.core.dao;

import com.amayadream.webchat.core.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-22 16:51
 */
@Repository
public interface IUserDao {

    User selectByPrimaryKey(String userId);

    List<User> list();

    int insert(User user);

    int update(User user);

}
