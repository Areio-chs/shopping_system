package com.shop.service;


import com.shop.pojo.PageResult;
import com.shop.pojo.Preferential;

import java.util.*;

/**
 * preferential业务逻辑层
 */
public interface PreferentialService {


    public List<Preferential> findAll();


    public PageResult<Preferential> findPage(int page, int size);


    public List<Preferential> findList(Map<String, Object> searchMap);


    public PageResult<Preferential> findPage(Map<String, Object> searchMap, int page, int size);


    public Preferential findById(Integer id);

    public void add(Preferential preferential);


    public void update(Preferential preferential);


    public void delete(Integer id);

}
