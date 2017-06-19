package com.amayadream.webchat.common.result;

import java.io.Serializable;

/**
 * 返回值实体
 * @author :  Amayadream
 * @date :  2017.06.12 22:18
 */
public class Results {

    /** 状态码 */
    private Integer code;
    /** 信息 */
    private String msg;
    /** 数据 */
    private Serializable data;

    private Results(Integer code, String msg, Serializable data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Results ok(ResultConstant c) {
        return new Results(c.code, c.message, null);
    }

    public static Results ok(ResultConstant c, Serializable data) {
        return new Results(c.code, c.message, data);
    }

    public static Results nok(ResultConstant c) {
        return new Results(c.code, c.message, null);
    }

    public static Results nok(ResultConstant c, Serializable data) {
        return new Results(c.code, c.message, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Serializable getData() {
        return data;
    }

    public void setData(Serializable data) {
        this.data = data;
    }
}
