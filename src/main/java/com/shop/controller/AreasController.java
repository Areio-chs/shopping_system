package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Areas;
import com.shop.service.AreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/areas")
public class AreasController {

    @Autowired
    private AreasService areasService;

    @GetMapping("/findAll")
    public List<Areas> findAll(){
        return areasService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Areas> findPage(int page, int size){
        return areasService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Areas> findList(@RequestBody Map<String,Object> searchMap){
        return areasService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Areas> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  areasService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Areas findById(String areaId){
        return areasService.findById(areaId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Areas areas){
        areasService.add(areas);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Areas areas){
        areasService.update(areas);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String areaId){
        areasService.delete(areaId);
        return new Result();
    }

}
