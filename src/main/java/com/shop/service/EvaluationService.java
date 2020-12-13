package com.shop.service;


import com.shop.pojo.Evaluation;
import com.shop.pojo.PageResult;

import java.util.*;

/**
 * evaluation业务逻辑层
 */
public interface EvaluationService {


    public List<Evaluation> findAll();


    public PageResult<Evaluation> findPage(int page, int size);


    public List<Evaluation> findList(Map<String, Object> searchMap);


    public PageResult<Evaluation> findPage(Map<String, Object> searchMap, int page, int size);


    public Evaluation findById(String id);

    public void add(Evaluation evaluation);


    public void update(Evaluation evaluation);


    public void delete(String id);

}
