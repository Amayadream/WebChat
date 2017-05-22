package com.amayadream.webchat.core.dao;

import com.amayadream.webchat.core.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-22 16:51
 */
@Service
public interface IUserDao {

    List<User> list();

    int insert(User user);

}
