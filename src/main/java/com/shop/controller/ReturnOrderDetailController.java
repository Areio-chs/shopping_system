package com.shop.controller;

import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.ReturnOrderDetail;
import com.shop.service.ReturnOrderDetailService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/returnOrderDetail")
public class ReturnOrderDetailController {

    @Reference
    private ReturnOrderDetailService returnOrderDetailService;

    @GetMapping("/findAll")
    public List<ReturnOrderDetail> findAll(){
        return returnOrderDetailService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<ReturnOrderDetail> findPage(int page, int size){
        return returnOrderDetailService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<ReturnOrderDetail> findList(@RequestBody Map<String,Object> searchMap){
        return returnOrderDetailService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<ReturnOrderDetail> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  returnOrderDetailService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public ReturnOrderDetail findById(String id){
        return returnOrderDetailService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody ReturnOrderDetail returnOrderDetail){
        returnOrderDetailService.add(returnOrderDetail);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ReturnOrderDetail returnOrderDetail){
        returnOrderDetailService.update(returnOrderDetail);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        returnOrderDetailService.delete(id);
        return new Result();
    }

}
