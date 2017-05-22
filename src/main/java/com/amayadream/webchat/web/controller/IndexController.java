package com.amayadream.webchat.web.controller;

import com.alibaba.fastjson.JSON;
import com.amayadream.webchat.core.dao.IUserDao;
import com.amayadream.webchat.core.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Amayadream
 * @date :   2017-05-22 16:59
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    @Resource
    private IUserDao userDao;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public String index() {
        LocalDateTime dateTime = LocalDateTime.now();
        User u = new User("Amayadream", "M", "hello", "hello", dateTime);
        int i = userDao.insert(u);
        return i + "";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public String list() {
        List<User> list = userDao.list();
        return JSON.toJSONString(list);
    }

}
