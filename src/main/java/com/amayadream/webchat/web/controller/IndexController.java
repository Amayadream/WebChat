package com.amayadream.webchat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : Amayadream
 * @date :   2017-05-22 16:59
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

}
