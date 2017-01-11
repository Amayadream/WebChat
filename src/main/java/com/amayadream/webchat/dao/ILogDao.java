package com.amayadream.webchat.dao;

import com.amayadream.webchat.pojo.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NAME   :  WebChat/com.amayadream.webchat.dao
 * Author :  Amayadream
 * Date   :  2016.01.09 16:39
 */
@Service(value = "logDao")
public interface ILogDao {
    List<Log> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    List<Log> selectLogByUserid(@Param("userid") String userid, @Param("offset") int offset, @Param("limit") int limit);

    Log selectCount();

    Log selectCountByUserid(@Param("userid") String userid);

    boolean insert(Log log);

    boolean delete(String id);

    boolean deleteThisUser(String userid);

    boolean deleteAll();
}
