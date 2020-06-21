package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UsersService usersService;
    //添加用户
    @PostMapping("/addUser")
    public String addUser(User users){
        try {
            this.usersService.addUsers(users);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/success";
    }

}
