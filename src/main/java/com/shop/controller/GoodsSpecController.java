package com.shop.controller;

import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.GoodsSpec;
import com.shop.service.GoodsSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/goodsSpec")
public class GoodsSpecController {

    @Autowired
    private GoodsSpecService goodsSpecService;

    @GetMapping("/findAll")
    public List<GoodsSpec> findAll(){
        return goodsSpecService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<GoodsSpec> findPage(int page, int size){
        return goodsSpecService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<GoodsSpec> findList(@RequestBody Map<String,Object> searchMap){

        return goodsSpecService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<GoodsSpec> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  goodsSpecService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public GoodsSpec findById(Integer id){
        return goodsSpecService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody GoodsSpec goodsSpec){
        goodsSpecService.add(goodsSpec);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody GoodsSpec goodsSpec){
        goodsSpecService.update(goodsSpec);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        goodsSpecService.delete(id);
        return new Result();
    }

}
