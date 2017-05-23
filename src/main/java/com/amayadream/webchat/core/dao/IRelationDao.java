package com.amayadream.webchat.core.dao;

import com.amayadream.webchat.core.model.Relation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 10:17
 */
@Repository
public interface IRelationDao {

    List<Relation> list(Relation relation);

    int insert(Relation relation);

    int delete(Relation relation);

}
