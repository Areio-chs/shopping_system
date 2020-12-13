package com.shop.service;


import com.shop.pojo.OperatorLog;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * operatorLog业务逻辑层
 */
public interface OperatorLogService {


    public List<OperatorLog> findAll();


    public PageResult<OperatorLog> findPage(int page, int size);


    public List<OperatorLog> findList(Map<String, Object> searchMap);


    public PageResult<OperatorLog> findPage(Map<String, Object> searchMap, int page, int size);


    public OperatorLog findById(String id);

    public void add(OperatorLog operatorLog);


    public void update(OperatorLog operatorLog);


    public void delete(String id);

}
