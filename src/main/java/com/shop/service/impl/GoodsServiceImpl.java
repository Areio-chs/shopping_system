package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.CategoryMapper;
import com.shop.dao.GoodsMapper;
import com.shop.dao.GoodsSpecMapper;
import com.shop.pojo.Category;
import com.shop.pojo.GoodsSpec;
import com.shop.pojo.PageResult;
import com.shop.pojo.Goods;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsSpecMapper goodsSpecMapper;
    @Autowired
    private CategoryMapper categoryMapper;

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
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        for (Goods goods : goodsList) {
            if (!(goods.getCategoryId()==null)){
                Category category = categoryMapper.selectByPrimaryKey(goods.getCategoryId());
                goods.setCategoryName(category.getName());
            }
        }
        Page<Goods> goods = (Page<Goods>) goodsList;
        return new PageResult<Goods>(goods.getTotal(),goods.getResult());
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
    public void add(Goods goods,String spec) {
        String[] atrArray = spec.split(",");

        goods.setId("09");
        goods.setCreated(new Date());
        goods.setSales(0);
        goods.setStatus("1");
        System.out.println(goods.toString());
        System.out.println(spec);
        goodsMapper.insert(goods);
        //规格数组，在规格与数组中间表插上
        GoodsSpec goodsSpec = new GoodsSpec();
        for (int i=0;i<atrArray.length;i++){
            goodsSpec.setGoodId(goods.getId());
            goodsSpec.setSpecId(atrArray[i]);
            goodsSpecMapper.insert(goodsSpec);
        }
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
            // 名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
        }
        return example;
    }

}
