package com.shop.service;


import com.shop.pojo.Cart;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * cart业务逻辑层
 */
public interface CartService {


    public List<Cart> findAll();


    public PageResult<Cart> findPage(int page, int size);


    public List<Cart> findList(Map<String, Object> searchMap);


    public PageResult<Cart> findPage(Map<String, Object> searchMap, int page, int size);


    public Cart findById(String id);

    public void add(Cart cart);


    public void update(Cart cart);


    public void delete(String id);

}
