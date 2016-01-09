package com.amayadream.webchat.controller;

import com.amayadream.webchat.pojo.Log;
import com.amayadream.webchat.pojo.User;
import com.amayadream.webchat.service.ILogService;
import com.amayadream.webchat.service.IUserService;
import com.amayadream.webchat.utils.UploadUtil;
import com.amayadream.webchat.utils.WordDefined;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * NAME   :  WebChat/com.amayadream.webchat.controller
 * Author :  Amayadream
 * Date   :  2016.01.09 17:56
 * TODO   :  用户控制器
 */
@Controller
@SessionAttributes("userid")
public class UserController {
    @Resource private User user;
    @Resource private IUserService userService;
    @Resource private Log log;
    @Resource private ILogService logService;

    @RequestMapping(value = "create")
    public void create(){

    }

    /**
     * 显示个人信息
     * @param userid
     * @param sessionid
     * @return
     */
    @RequestMapping(value = "{userid}", method = RequestMethod.GET)
    public ModelAndView selectUserByUserid(@PathVariable("userid") String userid, @ModelAttribute("userid") String sessionid){
        ModelAndView view = new ModelAndView("apps/information");
        user = userService.selectUserByUserid(userid);
        view.addObject("user", user);
        return view;
    }

    /**
     * 显示个人信息编辑页面
     * @param userid
     * @param sessionid
     * @return
     */
    @RequestMapping(value = "{userid}/config")
    public ModelAndView setting(@PathVariable("userid") String userid, @ModelAttribute("userid") String sessionid){
        ModelAndView view = new ModelAndView("apps/info-setting");
        user = userService.selectUserByUserid(userid);
        view.addObject("user", user);
        return view;
    }

    /**
     * 更新用户信息
     * @param userid
     * @param sessionid
     * @param user
     * @param attributes
     * @return
     */
    @RequestMapping(value = "{userid}/update", method = RequestMethod.POST)
    public String  update(@PathVariable("userid") String userid, @ModelAttribute("userid") String sessionid, User user, RedirectAttributes attributes){
        boolean flag = userService.update(user);
        if(flag){
            attributes.addFlashAttribute("message", "["+userid+"]资料更新成功!");
        }else{
            attributes.addFlashAttribute("error", "["+userid+"]资料更新失败!");
        }
        return "redirect:/{userid}/config";
    }

    /**
     * 修改密码
     * @param userid
     * @param oldpass
     * @param newpass
     * @param attributes
     * @return
     */
    @RequestMapping(value = "{userid}/pass", method = RequestMethod.POST)
    public String changePassword(@PathVariable("userid") String userid, String oldpass, String newpass, RedirectAttributes attributes){
        user = userService.selectUserByUserid(userid);
        if(oldpass.equals(user.getPassword())){
            user.setPassword(newpass);
            boolean flag = userService.update(user);
            if(flag){
                attributes.addFlashAttribute("message", "["+userid+"]密码更新成功!");
            }else{
                attributes.addFlashAttribute("error", "["+userid+"]密码更新失败!");
            }
        }else{
            attributes.addFlashAttribute("error", "密码错误!");
        }
        return "redirect:/{userid}/config";
    }

    @RequestMapping(value = "{userid}/upload")
    public String upload(@PathVariable("userid") String userid, MultipartFile file, HttpServletRequest request, UploadUtil uploadUtil, RedirectAttributes attributes){
        try{
            String fileurl = uploadUtil.upload(request, "upload", userid);
            user = userService.selectUserByUserid(userid);
            user.setProfilehead(fileurl);
            boolean flag = userService.update(user);
            if(flag){
                attributes.addFlashAttribute("message", "["+userid+"]头像更新成功!");
            }else{
                attributes.addFlashAttribute("error", "["+userid+"]头像更新失败!");
            }
        } catch (Exception e){
            attributes.addFlashAttribute("error", "["+userid+"]头像更新失败!");
        }
        return "redirect:/{userid}/config";
    }

}
