package com.shop.service;


import com.shop.pojo.GoodsSpec;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * goodsSpec业务逻辑层
 */
public interface GoodsSpecService {


    public List<GoodsSpec> findAll();


    public PageResult<GoodsSpec> findPage(int page, int size);


    public List<GoodsSpec> findList(Map<String, Object> searchMap);


    public PageResult<GoodsSpec> findPage(Map<String, Object> searchMap, int page, int size);


    public GoodsSpec findById(Integer id);

    public void add(GoodsSpec goodsSpec);


    public void update(GoodsSpec goodsSpec);


    public void delete(Integer id);

}
