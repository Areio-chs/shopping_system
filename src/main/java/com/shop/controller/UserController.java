package com.shop.controller;


import com.shop.pojo.User;
import com.shop.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }


}
