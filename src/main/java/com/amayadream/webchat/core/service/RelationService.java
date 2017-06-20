package com.amayadream.webchat.core.service;

import com.amayadream.webchat.core.model.Relation;

import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:20
 */
public interface RelationService {

    List<Relation> list(Relation relation);

    int insert(Relation relation);

    int delete(Relation relation);

}
