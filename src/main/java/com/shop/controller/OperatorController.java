package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Operator;
import com.shop.service.OperatorService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/operator")
public class OperatorController {

    @Reference
    private OperatorService operatorService;

    @GetMapping("/findAll")
    public List<Operator> findAll(){
        return operatorService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Operator> findPage(int page, int size){
        return operatorService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Operator> findList(@RequestBody Map<String,Object> searchMap){
        return operatorService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Operator> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  operatorService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Operator findById(String id){
        return operatorService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Operator operator){
        operatorService.add(operator);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Operator operator){
        operatorService.update(operator);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        operatorService.delete(id);
        return new Result();
    }

}
