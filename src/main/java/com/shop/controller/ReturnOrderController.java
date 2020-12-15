package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.ReturnOrder;
import com.shop.service.ReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/returnOrder")
public class ReturnOrderController {

    @Autowired
    private ReturnOrderService returnOrderService;

    @GetMapping("/findAll")
    public List<ReturnOrder> findAll(){
        return returnOrderService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<ReturnOrder> findPage(int page, int size){
        return returnOrderService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<ReturnOrder> findList(@RequestBody Map<String,Object> searchMap){
        return returnOrderService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<ReturnOrder> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  returnOrderService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public ReturnOrder findById(String id){
        return returnOrderService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody ReturnOrder returnOrder){
        returnOrderService.add(returnOrder);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ReturnOrder returnOrder){
        returnOrderService.update(returnOrder);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        returnOrderService.delete(id);
        return new Result();
    }

}
