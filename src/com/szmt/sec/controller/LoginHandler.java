package com.szmt.sec.controller;

import com.szmt.sec.po.Users;
import com.szmt.sec.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2015-11-10.
 */
@Controller
public class LoginHandler {
    @Resource
    private UserService userService;

    @RequestMapping("/Login")
    public String login() {
        return "Login";
    }

    @RequestMapping("Logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("uname",null);
        return "redirect:Login";
    }

    @RequestMapping("/Regist")
    public String regist() {
        return "Regist";
    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, Users user, Model model) {
        Users userTrue = userService.selectByPrimaryKey(user.getUname());
        if (userTrue == null || !userTrue.getPassword().equals(user.getPassword())) {
            model.addAttribute("errorMsg", "用户名或密码错误");
            return "Login";
        }
        request.getSession().setAttribute("uname", user.getUname());
        return "redirect:stuIndex";
//        return "stuList";
    }

    @RequestMapping("/doRegist")
    public String doRegist(Users user, Model model,HttpServletRequest request) {
        if (user.getPassword() == null || user.getUname() == null || user.getPassword().trim().isEmpty() || user.getUname().trim().isEmpty()) {
            model.addAttribute("errorMsg", "请正确填写用户名或密码！");
            return "Regist";
        }
        Users userTrue = userService.selectByPrimaryKey(user.getUname());
        if (userTrue != null) {
            model.addAttribute("errorMsg", "用户名已存在！");
            return "Regist";
        }
        userService.insert(user);
        request.getSession().setAttribute("uname",user.getUname());     //添加用户权限
        return "redirect:stuIndex";
    }
}
