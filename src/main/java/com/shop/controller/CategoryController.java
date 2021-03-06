package com.shop.controller;

import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.Category;
import com.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAll")
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Category> findPage(int page, int size){
        return categoryService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Category> findList(@RequestBody Map<String,Object> searchMap){
        return categoryService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Category> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  categoryService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Category findById(String id){
        return categoryService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Category category){
        categoryService.add(category);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Category category){
        categoryService.update(category);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        categoryService.delete(id);
        return new Result();
    }

}
