package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.StoreMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.Store;
import com.shop.service.StoreService;
import com.shop.utils.RandomIdUtils;
import com.shop.utils.commUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    public Store doLogin(Store store) {
        Store store1 = new Store();
        store1.setUsername(store.getUsername());
        store1.setPassword(store.getPassword());
        List<Store> storeList = storeMapper.select(store1);
        Store store2 = new Store();
        if (commUtils.collectionEffective(storeList)){
            //判断这个集合是否为空再取，
            store2 = storeList.get(0);
            //更新登录状态
            store2.setLastLoginTime(new Date());
            storeMapper.updateByPrimaryKeySelective(store2);
        }
        return store2;
    }

    @Override
    public PageResult<Store> ofindPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample2(searchMap);
        Page<Store> stores = (Page<Store>) storeMapper.selectByExample(example);
        for (Store store:stores){
            String status = store.getStatus();
            if (!(status==null)) {
                if (status.equals("1")) {
                    store.setStatusName("正常");
                } else {
                    store.setStatusName("禁用");
                }
            }
        }
        return new PageResult<Store>(stores.getTotal(),stores.getResult());
    }
    private Example createExample2(Map<String, Object> searchMap){
        Example example=new Example(Store.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 用户名
            if(searchMap.get("username")!=null && !"".equals(searchMap.get("username"))){
                criteria.andLike("username","%"+searchMap.get("username")+"%");
            }
        }
        return example;
    }
    @Override
    public void forbidden(String storeId) {
        Store store = new Store();
        store.setId(storeId);
        store.setStatus("0");
        storeMapper.updateByPrimaryKeySelective(store);
    }

    @Override
    public void open(String storeId) {
        Store store = new Store();
        store.setId(storeId);
        store.setStatus("1");
        storeMapper.updateByPrimaryKeySelective(store);
    }

    @Override
    public int updatePass(Store store,String id,String newPass) {
        int result =1;
        //判断旧的密码对不对
        //1.查询当前登录的人旧密码
        Store store1 = new Store();
        store1.setId(id);
        Store store2 = storeMapper.selectByPrimaryKey(store1);
        if (!store2.getPassword().equals(store.getPassword())){//旧密码不对
            result = 0;
        }else {//旧密码对了，允许修改
            store.setId(id);
            store.setPassword(newPass);
            storeMapper.updateByPrimaryKeySelective(store);
            result = 1 ;
        }
        return  result;
    }

    @Override
    public int status(Store store) {
        int result=0;
        Store store1 = new Store();
        store1.setUsername(store.getUsername());
        List<Store> storeList = storeMapper.select(store1);
        Store store2 = new Store();
        if (commUtils.collectionEffective(storeList)){
            //判断这个集合是否为空再取，
            store2 = storeList.get(0);
            String status = store2.getStatus();
            if (status.equals("1")){
                result = 1;
            }

        }
        return result;
    }

    /**
     * 新增
     * @param store
     */
    public int add(Store store) {
        int result = findStoreByName(store.getUsername());
        if (result==1){
            store.setId(RandomIdUtils.getUUID());
            store.setCreated(new Date());
            store.setStatus("1");
            storeMapper.insert(store);}
        return result;
    }

    public int findStoreByName(String username){
        int result=1;
        Store store = new Store();
        store.setUsername(username);
        List<Store> storeList = storeMapper.select(store);
        if (commUtils.collectionEffective(storeList)){
            result = 0;//代表该用户名已存在
        }
        return result;
    }

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
     * 修改
     * @param store
     */
    public void update(Store store) {
        store.setUpdated(new Date());
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
