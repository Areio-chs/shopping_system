package com.shop.service;


import com.shop.pojo.OrderDetail;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * orderDetail业务逻辑层
 */
public interface OrderDetailService {


    public List<OrderDetail> findAll();


    public PageResult<OrderDetail> findPage(int page, int size);


    public List<OrderDetail> findList(Map<String, Object> searchMap);


    public PageResult<OrderDetail> findPage(Map<String, Object> searchMap, int page, int size);

    public List<OrderDetail> findByOrderId(String orderId);

    public OrderDetail findById(String id);

    public void returned(String id);

    public void add(OrderDetail orderDetail);


    public void update(OrderDetail orderDetail);


    public void delete(String id);

}
