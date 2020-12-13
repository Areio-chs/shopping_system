package com.shop.service;


import com.shop.pojo.PageResult;
import com.shop.pojo.UserLog;

import java.util.*;

/**
 * userLog业务逻辑层
 */
public interface UserLogService {


    public List<UserLog> findAll();


    public PageResult<UserLog> findPage(int page, int size);


    public List<UserLog> findList(Map<String, Object> searchMap);


    public PageResult<UserLog> findPage(Map<String, Object> searchMap, int page, int size);


    public UserLog findById(String id);

    public void add(UserLog userLog);


    public void update(UserLog userLog);


    public void delete(String id);

}
