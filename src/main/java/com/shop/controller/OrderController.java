package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Order;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Order> findPage(int page, int size){
        return orderService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Order> findList(@RequestBody Map<String,Object> searchMap){
        return orderService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Order> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  orderService.findPage(searchMap,page,size);
    }
    @PostMapping("/sfindPage")
    public PageResult<Order> sfindPage(@RequestBody Map<String,Object> searchMap,int page, int size,String storeId){
        return  orderService.sfindPage(searchMap,page,size,storeId);
    }
    @GetMapping("/findById")
    public Order findById(String id){
        return orderService.findById(id);
    }

    @GetMapping("/delivery")
    public Result delivery(String orderId){
        orderService.delivery(orderId);
        return  new Result();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Order order){
        //orderService.add(order);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Order order){
        orderService.update(order);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        orderService.delete(id);
        return new Result();
    }

    @GetMapping("/updateTime")
    public Result updateTime(String id){
        Order order = orderService.findById(id);
        order.setPaymenttime(new Date());
        order.setUpdated(new Date());
        order.setStatus("2");
        orderService.update(order);
        return new Result();
    }

    @GetMapping("/updateStatus")
    public Result updateStatus(String id){
        Order order = orderService.findById(id);
        order.setUpdated(new Date());
        order.setStatus("4");
        orderService.update(order);
        return new Result();
    }



}
