package com.shop.controller;


import com.shop.pojo.*;
import com.shop.service.EvaluationService;
import com.shop.service.OrderDetailService;
import com.shop.service.OrderService;
import com.shop.utils.RandomIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public List<Evaluation> findAll(){
        return evaluationService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Evaluation> findPage(int page, int size){
        return evaluationService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Evaluation> findList(@RequestBody Map<String,Object> searchMap){
        return evaluationService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Evaluation> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  evaluationService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Evaluation findById(String id){
        return evaluationService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Evaluation evaluation){
        evaluation.setId(RandomIdUtils.getUUID());
        evaluation.setTime(new Date());
        evaluationService.add(evaluation);
        Order order = orderService.findById(orderDetailService.findById(evaluation.getOrderDetailId()).getOrderId());
        order.setStatus("5");
        order.setUpdated(new Date());
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Evaluation evaluation){
        evaluationService.update(evaluation);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        evaluationService.delete(id);
        return new Result();
    }

}
