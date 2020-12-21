package com.shop.controller;


import com.shop.pojo.GoodsSpec;
import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Goods;
import com.shop.service.GoodsService;
import com.shop.service.GoodsSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
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
    public List<Goods> findList(@RequestBody Map<String,Object> searchMap){ return goodsService.findList(searchMap); }

    @PostMapping("/findPage")
    public PageResult<Goods> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        System.out.println(searchMap.get("name"));
        return goodsService.findPage(searchMap,page,size);
    }
    @PostMapping("/sfindPage")
    public PageResult<Goods> sfindPage(@RequestBody Map<String,Object> searchMap,int page, int size,String storeId){
        System.out.println(searchMap.get("name"));
        return goodsService.sfindPage(searchMap,page,size,storeId);
    }
    @GetMapping("/findById")
    public Goods findById(String id){
        return goodsService.findById(id);
    }

    @GetMapping("/findSpec")
    public List<String> findSpec(String id){
        return goodsService.findSpecList(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Goods goods,String spec,String storeId){

        goodsService.add(goods, spec,storeId);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Goods goods,String spec){
//        System.out.println(spec+"!!!!!!");
        goodsService.update(goods,spec);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        //除了删除商品的东西，还要删除商品的规格
        goodsService.delete(id);
        return new Result();
    }

}
