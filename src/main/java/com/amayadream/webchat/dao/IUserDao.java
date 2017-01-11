package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NAME   :  WebChat/com.amayadream.webchat.dao
 * Author :  Amayadream
 * Date   :  2016.01.08 14:30
 * TODO   :
 */
@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    User selectUserByUserid(String userid);

    User selectCount();

    boolean insert(User user);

    boolean update(User user);

    boolean delete(String userid);
}
