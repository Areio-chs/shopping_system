package com.shop.service;
import com.shop.pojo.PageResult;
import com.shop.pojo.Store;

import java.util.*;
/**
 * store业务逻辑层
 */
public interface StoreService {
    public List<Store> findAll();

    public PageResult<Store> findPage(int page, int size);

    public List<Store> findList(Map<String, Object> searchMap);

    public PageResult<Store> findPage(Map<String, Object> searchMap, int page, int size);

    public Store findById(String id);

    public int add(Store store);

    public void update(Store store);

    public void delete(String id);

    public Store doLogin(Store store);

    PageResult<Store> ofindPage(Map<String, Object> searchMap, int page, int size);

    void forbidden(String storeId);

    void open(String storeId);

    int updatePass(Store store,String id,String newPass);

    int status(Store store);
}
