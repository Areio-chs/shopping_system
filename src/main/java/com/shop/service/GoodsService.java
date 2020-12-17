package com.shop.service;


import com.shop.pojo.Goods;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * goods业务逻辑层
 */
public interface GoodsService {


    public List<Goods> findAll();


    public PageResult<Goods> findPage(int page, int size);


    public List<Goods> findList(Map<String, Object> searchMap);


    public PageResult<Goods> findPage(Map<String, Object> searchMap, int page, int size);


    public Goods findById(String id);

    public void add(Goods goods,String spec);


    public void update(Goods goods);


    public void delete(String id);
}
