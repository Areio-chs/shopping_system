package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.OperatorMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.Operator;
import com.shop.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Operator> findAll() {
        return operatorMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Operator> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Operator> operators = (Page<Operator>) operatorMapper.selectAll();
        return new PageResult<Operator>(operators.getTotal(),operators.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Operator> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return operatorMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Operator> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Operator> operators = (Page<Operator>) operatorMapper.selectByExample(example);
        return new PageResult<Operator>(operators.getTotal(),operators.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Operator findById(String id) {
        return operatorMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param operator
     */
    public void add(Operator operator) {
        operatorMapper.insert(operator);
    }

    /**
     * 修改
     * @param operator
     */
    public void update(Operator operator) {
        operatorMapper.updateByPrimaryKeySelective(operator);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        operatorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Operator.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // username
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
            }
            // password
            if(searchMap.get("password")!=null && !"".equals(searchMap.get("password"))){
                criteria.andLike("password","%"+searchMap.get("password")+"%");
            }


        }
        return example;
    }

}
