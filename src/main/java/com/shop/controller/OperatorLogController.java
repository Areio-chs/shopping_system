package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.OperatorLog;
import com.shop.service.OperatorLogService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/operatorLog")
public class OperatorLogController {

    @Reference
    private OperatorLogService operatorLogService;

    @GetMapping("/findAll")
    public List<OperatorLog> findAll(){
        return operatorLogService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<OperatorLog> findPage(int page, int size){
        return operatorLogService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<OperatorLog> findList(@RequestBody Map<String,Object> searchMap){
        return operatorLogService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<OperatorLog> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  operatorLogService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public OperatorLog findById(String id){
        return operatorLogService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody OperatorLog operatorLog){
        operatorLogService.add(operatorLog);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody OperatorLog operatorLog){
        operatorLogService.update(operatorLog);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        operatorLogService.delete(id);
        return new Result();
    }

}
