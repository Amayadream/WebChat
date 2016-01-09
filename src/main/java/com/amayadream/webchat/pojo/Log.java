package com.amayadream.webchat.pojo;

import org.springframework.stereotype.Repository;

/**
 * NAME   :  WebChat/com.amayadream.webchat.pojo
 * Author :  Amayadream
 * Date   :  2016.01.09 16:37
 * TODO   :  系统日志实体类
 */
@Repository(value = "log")
public class Log {
    private String id;      //日志编号
    private String userid;  //用户名
    private String time;    //时间
    private String type;    //类型
    private String detail;  //详情
    private String ip;      //ip地址

    /**
     * getter&setter
     * @return
     */
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
