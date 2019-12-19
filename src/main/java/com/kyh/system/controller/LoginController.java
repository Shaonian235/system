package com.kyh.system.controller;

import com.kyh.system.entity.User;
import com.kyh.system.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "login")
public class LoginController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/",method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "/login/login";
    }

    /***
     * 这是一种返回形式 以ModelAndView 视图返回数据的形式返回 和返回map一样 调用方式不一样
     * */
    @RequestMapping(value="/userLogin",method = {RequestMethod.POST, RequestMethod.GET})
    public  ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response,HttpSession session){
         ModelAndView model=new ModelAndView();
         String id=request.getParameter("id");
         String password=request.getParameter("password");
         System.out.println(id);
        System.out.println(password);
         User user=new User();
         User loginUser=new User();
         user.setPassword(password);
         user.setUserId(Integer.parseInt(id));
         loginUser=userService.getUserById(user);
         if(null!=loginUser){
             session.setAttribute("user",loginUser);
             model.setViewName("login/index");
         }else {
             model.addObject("MSG","用户名或密码错误");
             model.setViewName("/login/login");
         }
         return  model;
    }
    /**
     * 登录成功 加载欢迎页面  返回String y页面的路径和名称
     * */
    @RequestMapping(value="welcome",method = {RequestMethod.POST,RequestMethod.GET})
    public  String welcome(){
         return "/login/welcome";
    }
}
