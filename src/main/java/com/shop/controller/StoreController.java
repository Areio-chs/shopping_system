package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Store;
import com.shop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/findAll")
    public List<Store> findAll(){
        return storeService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Store> findPage(int page, int size){
        return storeService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Store> findList(@RequestBody Map<String,Object> searchMap){
        return storeService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Store> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  storeService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Store findById(String id){
        return storeService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Store store){
        storeService.add(store);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Store store){
        storeService.update(store);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        storeService.delete(id);
        return new Result();
    }

}
