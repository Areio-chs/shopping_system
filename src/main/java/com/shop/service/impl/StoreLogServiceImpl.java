package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.StoreLogMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.StoreLog;
import com.shop.service.StoreLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class StoreLogServiceImpl implements StoreLogService {

    @Autowired
    private StoreLogMapper storeLogMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<StoreLog> findAll() {
        return storeLogMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<StoreLog> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<StoreLog> storeLogs = (Page<StoreLog>) storeLogMapper.selectAll();
        return new PageResult<StoreLog>(storeLogs.getTotal(),storeLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<StoreLog> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return storeLogMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<StoreLog> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<StoreLog> storeLogs = (Page<StoreLog>) storeLogMapper.selectByExample(example);
        return new PageResult<StoreLog>(storeLogs.getTotal(),storeLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public StoreLog findById(String id) {
        return storeLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param storeLog
     */
    public void add(StoreLog storeLog) {
        storeLogMapper.insert(storeLog);
    }

    /**
     * 修改
     * @param storeLog
     */
    public void update(StoreLog storeLog) {
        storeLogMapper.updateByPrimaryKeySelective(storeLog);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        storeLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(StoreLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // store_id
            if(searchMap.get("storeId")!=null && !"".equals(searchMap.get("storeId"))){
                criteria.andLike("storeId","%"+searchMap.get("storeId")+"%");
            }
            // 操作者
            if(searchMap.get("operater")!=null && !"".equals(searchMap.get("operater"))){
                criteria.andLike("operater","%"+searchMap.get("operater")+"%");
            }
            // 操作内容
            if(searchMap.get("operating")!=null && !"".equals(searchMap.get("operating"))){
                criteria.andLike("operating","%"+searchMap.get("operating")+"%");
            }
            // 操作结果
            if(searchMap.get("result")!=null && !"".equals(searchMap.get("result"))){
                criteria.andLike("result","%"+searchMap.get("result")+"%");
            }


        }
        return example;
    }

}
