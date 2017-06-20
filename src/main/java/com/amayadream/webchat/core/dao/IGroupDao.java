package com.amayadream.webchat.core.dao;

import com.amayadream.webchat.core.model.Group;

import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:05
 */
public interface IGroupDao {

    Group selectByPrimaryKey(Long id);

    List<Group> list(Group group);



}
