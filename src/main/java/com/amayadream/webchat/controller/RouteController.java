package com.amayadream.webchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author :  Amayadream
 * Date   :  2016.01.09 17:54
 * TODO   :  路由控制器
 */
@Controller
public class RouteController {

    @RequestMapping(value = "")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "about")
    public String about() {
        return "about";
    }

    @RequestMapping(value = "help")
    public String help() {
        return "help";
    }

}
