package com.shop.service;


import com.shop.pojo.PageResult;
import com.shop.pojo.Spec;

import java.util.*;

/**
 * spec业务逻辑层
 */
public interface SpecService {


    public List<Spec> findAll();


    public PageResult<Spec> findPage(int page, int size);


    public List<Spec> findList(Map<String, Object> searchMap);


    public PageResult<Spec> findPage(Map<String, Object> searchMap, int page, int size);


    public Spec findById(String id);

    public void add(Spec spec);


    public void update(Spec spec);


    public void delete(String id);

}
