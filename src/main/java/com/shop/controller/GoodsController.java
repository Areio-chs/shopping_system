package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Goods;
import com.shop.service.GoodsService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    @GetMapping("/findAll")
    public List<Goods> findAll(){
        return goodsService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Goods> findPage(int page, int size){
        return goodsService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Goods> findList(@RequestBody Map<String,Object> searchMap){
        return goodsService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Goods> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  goodsService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Goods findById(String id){
        return goodsService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Goods goods){
        goodsService.add(goods);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Goods goods){
        goodsService.update(goods);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        goodsService.delete(id);
        return new Result();
    }

}
