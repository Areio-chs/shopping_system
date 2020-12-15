package com.shop.controller;

import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Provinces;
import com.shop.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/provinces")
public class ProvincesController {

    @Autowired
    private ProvincesService provincesService;

    @GetMapping("/findAll")
    public List<Provinces> findAll(){
        return provincesService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Provinces> findPage(int page, int size){
        return provincesService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Provinces> findList(@RequestBody Map<String,Object> searchMap){
        return provincesService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Provinces> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  provincesService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Provinces findById(String provinceId){
        return provincesService.findById(provinceId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Provinces provinces){
        provincesService.add(provinces);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Provinces provinces){
        provincesService.update(provinces);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String provinceId){
        provincesService.delete(provinceId);
        return new Result();
    }

}
