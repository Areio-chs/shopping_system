package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.StoreMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.Store;
import com.shop.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Store> findAll() {
        return storeMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Store> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Store> stores = (Page<Store>) storeMapper.selectAll();
        return new PageResult<Store>(stores.getTotal(),stores.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Store> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return storeMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Store> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Store> stores = (Page<Store>) storeMapper.selectByExample(example);
        return new PageResult<Store>(stores.getTotal(),stores.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Store findById(String id) {
        return storeMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param store
     */
    public void add(Store store) {
        storeMapper.insert(store);
    }

    /**
     * 修改
     * @param store
     */
    public void update(Store store) {
        storeMapper.updateByPrimaryKeySelective(store);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        storeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Store.class);
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
            // 店名
            if(searchMap.get("name")!=null && !"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            // 电话
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
            }
            // 地址
            if(searchMap.get("address")!=null && !"".equals(searchMap.get("address"))){
                criteria.andLike("address","%"+searchMap.get("address")+"%");
            }
            // 店铺照片
            if(searchMap.get("headPic")!=null && !"".equals(searchMap.get("headPic"))){
                criteria.andLike("headPic","%"+searchMap.get("headPic")+"%");
            }
            // 状态
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 外键，关联运营商
            if(searchMap.get("operatorsUsername")!=null && !"".equals(searchMap.get("operatorsUsername"))){
                criteria.andLike("operatorsUsername","%"+searchMap.get("operatorsUsername")+"%");
            }


        }
        return example;
    }

}
