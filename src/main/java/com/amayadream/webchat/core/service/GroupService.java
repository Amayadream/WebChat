package com.amayadream.webchat.core.service;

import com.amayadream.webchat.core.model.Group;

import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:20
 */
public interface GroupService {

    Group selectByPrimaryKey(Long id);

    List<Group> list(Group group);


}
