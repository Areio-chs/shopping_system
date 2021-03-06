package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.CategoryMapper;
import com.shop.dao.GoodsMapper;
import com.shop.dao.GoodsSpecMapper;
import com.shop.dao.SpecMapper;
import com.shop.pojo.*;
import com.shop.service.GoodsService;
import com.shop.utils.RandomIdUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
    @Autowired
    private SpecMapper specMapper;

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
            String status = goods.getStatus();
            if (!(status==null)){
                if (status.equals("1")){
                    goods.setStatusName("上架");
                }else {
                    goods.setStatusName("下架");
                }
            }
        }
        Page<Goods> goods = (Page<Goods>) goodsList;
        return new PageResult<Goods>(goods.getTotal(),goods.getResult());
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Goods> sfindPage(Map<String, Object> searchMap, int page, int size,String storeId) {
        PageHelper.startPage(page,size);
        Example example = createExample2(searchMap,storeId);
//        example.createCriteria().andEqualTo("storeId",storeId);
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        for (Goods goods : goodsList) {
            if (!(goods.getCategoryId()==null)){
                Category category = categoryMapper.selectByPrimaryKey(goods.getCategoryId());
                goods.setCategoryName(category.getName());
            }
            String status = goods.getStatus();
            if (!(status==null)){
                if (status.equals("1")){
                    goods.setStatusName("上架");
                }else {
                    goods.setStatusName("下架");
                }
            }
        }
        Page<Goods> goods = (Page<Goods>) goodsList;
        return new PageResult<Goods>(goods.getTotal(),goods.getResult());
    }

    @Override
    public int total(String storeId) {
        //统计该用户的商品总数
        Goods goods = new Goods();
        goods.setStoreId(storeId);
        int total = goodsMapper.selectCount(goods);
        return total;
    }

    private Example createExample2(Map<String, Object> searchMap,String storeId){
        Example example=new Example(Goods.class);
        Example.Criteria criteria = example.createCriteria();
        // id
        criteria.andEqualTo("storeId",storeId);
        if(searchMap!=null){
            // 名称
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
        }
        return example;
    }
    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Goods findById(String id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
    //根据商品id查询其对应的规格id，再查出名字
    public List<String> findSpecList(String id){
        GoodsSpec goodsSpec = new GoodsSpec();
        goodsSpec.setGoodId(id);
        List<GoodsSpec> specList = goodsSpecMapper.select(goodsSpec);
        List<String> specId = new ArrayList<String>();
        for (GoodsSpec goodsSpec1:specList){
            specId.add(goodsSpec1.getSpecId());
        }
        return specId;

    }
    /**
     * 新增
     * @param goods
     */
    public void add(Goods goods,String spec,String storeId) {
        String[] atrArray = spec.split(",");
        //暂时设置都是商家1在新增商品
        goods.setStoreId(storeId);
        goods.setId(RandomIdUtils.getUUID());
//        goods.setId("15");
        goods.setCreated(new Date());
        goods.setSpec("白色");
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
    public void update(Goods goods,String spec) {
        System.out.println(goods.toString());
        String[] atrArray = spec.split(",");
        GoodsSpec goodsSpec = new GoodsSpec();
        goodsSpec.setGoodId(goods.getId());
        //删除原来这个商品中全部的规格，再重新插回去
        goodsSpecMapper.delete(goodsSpec);
        for (int i=0;i<atrArray.length;i++){
            goodsSpec.setGoodId(goods.getId());
            goodsSpec.setSpecId(atrArray[i]);
            goodsSpecMapper.insert(goodsSpec);

        }
        goods.setUpdated(new Date());
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        //1.删除商品对应的规格
        GoodsSpec goodsSpec = new GoodsSpec();
        goodsSpec.setGoodId(id);
        goodsSpecMapper.delete(goodsSpec);
        //2.删除
        goodsMapper.deleteByPrimaryKey(id);
    }

    public boolean deductionStock(String id,Integer num) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        if ((goods.getStock()-num)<0){
            return false;
        }else {
            goods.setStock(goods.getStock()-num);
            goodsMapper.updateByPrimaryKey(goods);
            return true;
        }
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
                criteria.andEqualTo("id",searchMap.get("id"));
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
                criteria.andEqualTo("categoryId",searchMap.get("categoryId"));
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
