package com.shop.service;


import com.shop.pojo.PageResult;
import com.shop.pojo.StoreLog;

import java.util.*;

/**
 * storeLog业务逻辑层
 */
public interface StoreLogService {


    public List<StoreLog> findAll();


    public PageResult<StoreLog> findPage(int page, int size);


    public List<StoreLog> findList(Map<String, Object> searchMap);


    public PageResult<StoreLog> findPage(Map<String, Object> searchMap, int page, int size);


    public StoreLog findById(String id);

    public void add(StoreLog storeLog);


    public void update(StoreLog storeLog);


    public void delete(String id);

}
