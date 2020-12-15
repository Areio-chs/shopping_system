package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.StoreLog;
import com.shop.service.StoreLogService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/storeLog")
public class StoreLogController {

    @Reference
    private StoreLogService storeLogService;

    @GetMapping("/findAll")
    public List<StoreLog> findAll(){
        return storeLogService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<StoreLog> findPage(int page, int size){
        return storeLogService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<StoreLog> findList(@RequestBody Map<String,Object> searchMap){
        return storeLogService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<StoreLog> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  storeLogService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public StoreLog findById(String id){
        return storeLogService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody StoreLog storeLog){
        storeLogService.add(storeLog);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody StoreLog storeLog){
        storeLogService.update(storeLog);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        storeLogService.delete(id);
        return new Result();
    }

}
