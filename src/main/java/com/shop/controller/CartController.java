package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Cart;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/findAll")
    public List<Cart> findAll(){
        return cartService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Cart> findPage(int page, int size){
        return cartService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Cart> findList(@RequestBody Map<String,Object> searchMap){
        return cartService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Cart> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  cartService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Cart findById(String id){
        return cartService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Cart cart){
        cartService.add(cart);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Cart cart){
        cartService.update(cart);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        cartService.delete(id);
        return new Result();
    }

}
