package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.User;
import com.amayadream.webchat.service.IUserService;
import com.amayadream.webchat.utils.DateUtil;
import com.amayadream.webchat.utils.DefinedUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * NAME   :  WebChat/com.amayadream.webchat.controller
 * Author :  Amayadream
 * Date   :  2016.01.08 14:57
 * TODO   :
 */
@Controller
public class LoginController {
    @Resource private User user;
    @Resource private IUserService userService;

    @RequestMapping(value = "login")
    public String login(String userid, String password, HttpSession session, RedirectAttributes attributes, DefinedUtil definedUtil, DateUtil dateUtil){
        user = userService.selectUserByUserid(userid);
        if(user == null){
            attributes.addFlashAttribute("error", definedUtil.LOGIN_USERID_ERROR);
        }else{
            if(!user.getPassword().equals(password)){
                attributes.addFlashAttribute("error", definedUtil.LOGIN_PASSWORD_ERROR);
            }else{
                session.setAttribute("userid", userid);
                session.setAttribute("login_status", true);
                user.setLasttime(dateUtil.getDateTime24());
                userService.update(user);
                attributes.addFlashAttribute("message", definedUtil.LOGIN_SUCCESS);
                return "/index";
            }
        }
        return "/login";
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session, RedirectAttributes attributes, DefinedUtil definedUtil){
        session.removeAttribute("userid");
        session.removeAttribute("login_status");
        attributes.addFlashAttribute("message", definedUtil.LOGOUT_SUCCESS);
        return "/login";
    }
}
