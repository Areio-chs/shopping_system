package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Cities;
import com.shop.service.CitiesService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Reference
    private CitiesService citiesService;

    @GetMapping("/findAll")
    public List<Cities> findAll(){
        return citiesService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Cities> findPage(int page, int size){
        return citiesService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Cities> findList(@RequestBody Map<String,Object> searchMap){
        return citiesService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Cities> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  citiesService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Cities findById(String cityId){
        return citiesService.findById(cityId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Cities cities){
        citiesService.add(cities);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Cities cities){
        citiesService.update(cities);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String cityId){
        citiesService.delete(cityId);
        return new Result();
    }

}
