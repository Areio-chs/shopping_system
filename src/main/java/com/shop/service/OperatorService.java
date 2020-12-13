package com.shop.service;


import com.shop.pojo.Operator;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * operator业务逻辑层
 */
public interface OperatorService {


    public List<Operator> findAll();


    public PageResult<Operator> findPage(int page, int size);


    public List<Operator> findList(Map<String, Object> searchMap);


    public PageResult<Operator> findPage(Map<String, Object> searchMap, int page, int size);


    public Operator findById(String id);

    public void add(Operator operator);


    public void update(Operator operator);


    public void delete(String id);

}
