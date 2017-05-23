package com.amayadream.webchat.core.dao;

import com.amayadream.webchat.core.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author : Amayadream
 * @date :   2017-05-23 09:57
 */
@Repository
public interface IMessageDao {

    Message selectByPrimaryKey(Long id);

    List<Message> list(Message message);

    int insert(Message message);

}
