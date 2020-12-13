package com.shop.service;


import com.shop.pojo.PageResult;
import com.shop.pojo.ReturnOrderDetail;

import java.util.*;

/**
 * returnOrderDetail业务逻辑层
 */
public interface ReturnOrderDetailService {


    public List<ReturnOrderDetail> findAll();


    public PageResult<ReturnOrderDetail> findPage(int page, int size);


    public List<ReturnOrderDetail> findList(Map<String, Object> searchMap);


    public PageResult<ReturnOrderDetail> findPage(Map<String, Object> searchMap, int page, int size);


    public ReturnOrderDetail findById(String id);

    public void add(ReturnOrderDetail returnOrderDetail);


    public void update(ReturnOrderDetail returnOrderDetail);


    public void delete(String id);

}
