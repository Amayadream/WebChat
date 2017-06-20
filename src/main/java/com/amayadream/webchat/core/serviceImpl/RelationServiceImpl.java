package com.amayadream.webchat.core.serviceImpl;

import com.amayadream.webchat.core.dao.IRelationDao;
import com.amayadream.webchat.core.model.Relation;
import com.amayadream.webchat.core.service.RelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-23 14:21
 */
@Service
public class RelationServiceImpl implements RelationService {

    @Resource
    private IRelationDao relationDao;

    @Override
    public List<Relation> list(Relation relation) {
        return relationDao.list(relation);
    }

    @Override
    public int insert(Relation relation) {
        return relationDao.insert(relation);
    }

    @Override
    public int delete(Relation relation) {
        return relationDao.delete(relation);
    }
}
