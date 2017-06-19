package com.amayadream.webchat.web.controller;

import com.amayadream.webchat.common.util.Constants;
import com.amayadream.webchat.common.util.StringUtil;
import com.amayadream.webchat.core.model.User;
import com.amayadream.webchat.core.service.UserService;
import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * 认证控制器
 * @author : Amayadream
 * @date :   2017-05-23 11:06
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @Resource
    private UserService userService;

    /**
     * 跳转登录页
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 跳转注册页
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String userId, String password, HttpSession session, RedirectAttributes attr) {
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
            attr.addFlashAttribute("error", "用户名和密码不可为空!");
            return "redirect:/auth/login";
        }
        User u = userService.selectByPrimaryKey(userId);
        if (u == null) {
            attr.addFlashAttribute("error", "用户名不存在!");
            return "redirect:/auth/login";
        }
        String p = DigestUtils.md5DigestAsHex((password + u.getSalt()).getBytes(Charsets.UTF_8));
        if (!Objects.equal(p, u.getPassword())) {
            attr.addFlashAttribute("error", "密码错误!");
            return "redirect:/auth/login";
        }
        session.setAttribute(Constants.SESSION_USER, u);
        session.setAttribute(Constants.SESSION_USERID, userId);
        User user = new User(userId, LocalDateTime.now());
        userService.update(user);
        attr.addFlashAttribute("message", "登录成功!");
        return "redirect:/";
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(String userId, String password, RedirectAttributes attr) {
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(password)) {
            attr.addFlashAttribute("error", "用户名和密码不可为空!");
            return "redirect:/auth/register";
        }
        User u = userService.selectByPrimaryKey(userId);
        if (u != null) {
            attr.addFlashAttribute("error", "用户名已存在!");
            return "redirect:/auth/register";
        }
        String salt = StringUtil.getGuid();
        String p = DigestUtils.md5DigestAsHex((password + salt).getBytes(Charsets.UTF_8));
        User user = new User(userId, p, salt, StringUtil.getAvatarUrl(userId, Constants.AVATAR_SIZE), LocalDateTime.now());
        userService.insert(user);
        attr.addFlashAttribute("message", "注册成功!");
        return "redirect:/auth/login";
    }

    /**
     * 注销登录
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, RedirectAttributes attr) {
        session.invalidate();
        attr.addFlashAttribute("message", "注销成功!");
        return "redirect:/auth/login";
    }

}
