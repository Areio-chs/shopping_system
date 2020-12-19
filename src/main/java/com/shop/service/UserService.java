package com.shop.service;
import com.shop.pojo.PageResult;
import com.shop.pojo.User;

import java.util.*;

/**
 * user业务逻辑层
 */
public interface UserService {


    public List<User> findAll();


    public PageResult<User> findPage(int page, int size);


    public List<User> findList(Map<String, Object> searchMap);


    public PageResult<User> findPage(Map<String, Object> searchMap, int page, int size);


    public User findById(String id);

    public void add(User user);


    public void update(User user);


    public void delete(String id);

    public User doLogin(User user);
}
