package com.shop.controller;

import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public int add(@RequestBody User user){
       return userService.add(user);

    }
    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<User> findPage(int page, int size){
        return userService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<User> findList(@RequestBody Map<String,Object> searchMap){
        return userService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<User> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  userService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public User findById(String id){
        return userService.findById(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
       return userService.doLogin(user);
       //如果返回的用户是空的，那么就说明登录失败，返回的用户非空，说明登录成功
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        userService.delete(id);
        return new Result();
    }

}
