package com.mymall.controller;
import com.alibaba.fastjson.JSON;
import com.mymall.bean.User;
import com.mymall.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;

    @PostMapping("/api/login")
    public String login(@RequestParam( value="login_tel",required=false,defaultValue = "null") String login_tel,
                        @RequestParam( value="login_password",required=false,defaultValue = "null" ) String login_password){
        System.out.println("tel = "+ login_tel + "  ,  pass = "+login_password);
        User us = userDao.getUserByMessage(login_tel,login_password);
        System.out.println("us:" + us);
        return JSON.toJSONString(us);
    }

    @GetMapping("/test")
    public String login(){
        return "123";
//        return JSON.toJSONString(us);
    }
}
