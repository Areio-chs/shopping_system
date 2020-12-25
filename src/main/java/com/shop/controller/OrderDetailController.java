package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.OrderDetail;
import com.shop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/findAll")
    public List<OrderDetail> findAll(){
        return orderDetailService.findAll();
    }
    @GetMapping("/findByOrderId")
    public List<OrderDetail> findByOrderId(String orderId){
        return orderDetailService.findByOrderId(orderId);
    }
    @GetMapping("/findPage")
    public PageResult<OrderDetail> findPage(int page, int size){
        return orderDetailService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<OrderDetail> findList(@RequestBody Map<String,Object> searchMap){
        return orderDetailService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<OrderDetail> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  orderDetailService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public OrderDetail findById(String id){
        System.out.println(id);
        return orderDetailService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody OrderDetail orderDetail){
        orderDetailService.add(orderDetail);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody OrderDetail orderDetail){
        orderDetailService.update(orderDetail);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        orderDetailService.delete(id);
        return new Result();
    }
    @GetMapping("/returned")
    public Result returned(String id){
        orderDetailService.returned(id);
        return new Result();
    }
}
