package com.amayadream.webchat.utils;

import com.amayadream.webchat.pojo.Log;

/**
 * NAME   :  LeaveSystem/com.amayadream.leave.util
 * Author :  Amayadream
 * Date   :  2015.12.29 15:07
 * TODO   :
 */
public class LogUtil {

    public Log setLog(String userid, String time, String type, String detail, String ip){
         Log log = new Log();
        log.setUserid(userid);
        log.setTime(time);
        log.setType(type);
        log.setDetail(detail);
        log.setId(ip);
        return log;
    }

}
