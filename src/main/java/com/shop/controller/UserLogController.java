package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.UserLog;
import com.shop.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/userLog")
public class UserLogController {

    @Autowired
    private UserLogService userLogService;

    @GetMapping("/findAll")
    public List<UserLog> findAll(){
        return userLogService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<UserLog> findPage(int page, int size){
        return userLogService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<UserLog> findList(@RequestBody Map<String,Object> searchMap){
        return userLogService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<UserLog> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  userLogService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public UserLog findById(String id){
        return userLogService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody UserLog userLog){
        userLogService.add(userLog);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserLog userLog){
        userLogService.update(userLog);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        userLogService.delete(id);
        return new Result();
    }

}
