package com.shop.controller;


import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Evaluation;
import com.shop.service.EvaluationService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Reference
    private EvaluationService evaluationService;

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
        evaluationService.add(evaluation);
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
