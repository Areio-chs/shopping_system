package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.GoodsSpecMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.GoodsSpec;
import com.shop.service.GoodsSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class GoodsSpecServiceImpl implements GoodsSpecService {

    @Autowired
    private GoodsSpecMapper goodsSpecMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<GoodsSpec> findAll() {
        return goodsSpecMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<GoodsSpec> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<GoodsSpec> goodsSpecs = (Page<GoodsSpec>) goodsSpecMapper.selectAll();
        return new PageResult<GoodsSpec>(goodsSpecs.getTotal(),goodsSpecs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<GoodsSpec> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return goodsSpecMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<GoodsSpec> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<GoodsSpec> goodsSpecs = (Page<GoodsSpec>) goodsSpecMapper.selectByExample(example);
        return new PageResult<GoodsSpec>(goodsSpecs.getTotal(),goodsSpecs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public GoodsSpec findById(Integer id) {
        return goodsSpecMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param goodsSpec
     */
    public void add(GoodsSpec goodsSpec) {
        goodsSpecMapper.insert(goodsSpec);
    }

    /**
     * 修改
     * @param goodsSpec
     */
    public void update(GoodsSpec goodsSpec) {
        goodsSpecMapper.updateByPrimaryKeySelective(goodsSpec);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(Integer id) {
        goodsSpecMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(GoodsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // good_id
            if(searchMap.get("goodId")!=null && !"".equals(searchMap.get("goodId"))){
                criteria.andLike("goodId","%"+searchMap.get("goodId")+"%");
            }
            // spec_id
            if(searchMap.get("specId")!=null && !"".equals(searchMap.get("specId"))){
                criteria.andLike("specId","%"+searchMap.get("specId")+"%");
            }

            // id
            if(searchMap.get("id")!=null ){
                criteria.andEqualTo("id",searchMap.get("id"));
            }

        }
        return example;
    }

}
