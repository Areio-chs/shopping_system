package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.GoodsMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.Goods;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Goods> findAll() {
        return goodsMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Goods> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Goods> goodss = (Page<Goods>) goodsMapper.selectAll();
        return new PageResult<Goods>(goodss.getTotal(),goodss.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Goods> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return goodsMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Goods> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Goods> goodss = (Page<Goods>) goodsMapper.selectByExample(example);
        return new PageResult<Goods>(goodss.getTotal(),goodss.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Goods findById(String id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param goods
     */
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

    /**
     * 修改
     * @param goods
     */
    public void update(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // 名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 图片
            if(searchMap.get("img")!=null && !"".equals(searchMap.get("img"))){
                criteria.andLike("img","%"+searchMap.get("img")+"%");
            }
            // 简介
            if(searchMap.get("introduction")!=null && !"".equals(searchMap.get("introduction"))){
                criteria.andLike("introduction","%"+searchMap.get("introduction")+"%");
            }
            // 规格，由规格表拼接而成
            if(searchMap.get("spec")!=null && !"".equals(searchMap.get("spec"))){
                criteria.andLike("spec","%"+searchMap.get("spec")+"%");
            }
            // 状态
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 分类
            if(searchMap.get("categoryId")!=null && !"".equals(searchMap.get("categoryId"))){
                criteria.andLike("categoryId","%"+searchMap.get("categoryId")+"%");
            }

            // 库存
            if(searchMap.get("stock")!=null ){
                criteria.andEqualTo("stock",searchMap.get("stock"));
            }
            // 销量
            if(searchMap.get("sales")!=null ){
                criteria.andEqualTo("sales",searchMap.get("sales"));
            }

        }
        return example;
    }

}
