package com.shop.service;


import com.shop.pojo.Areas;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * areas业务逻辑层
 */
public interface AreasService {


    public List<Areas> findAll();


    public PageResult<Areas> findPage(int page, int size);


    public List<Areas> findList(Map<String, Object> searchMap);


    public PageResult<Areas> findPage(Map<String, Object> searchMap, int page, int size);


    public Areas findById(String area_id);

    public void add(Areas areas);


    public void update(Areas areas);


    public void delete(String area_id);

}
