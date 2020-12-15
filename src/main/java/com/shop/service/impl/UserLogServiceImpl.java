package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.UserLogMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.UserLog;
import com.shop.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class UserLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogMapper userLogMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<UserLog> findAll() {
        return userLogMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<UserLog> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<UserLog> userLogs = (Page<UserLog>) userLogMapper.selectAll();
        return new PageResult<UserLog>(userLogs.getTotal(),userLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<UserLog> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return userLogMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<UserLog> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<UserLog> userLogs = (Page<UserLog>) userLogMapper.selectByExample(example);
        return new PageResult<UserLog>(userLogs.getTotal(),userLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public UserLog findById(String id) {
        return userLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param userLog
     */
    public void add(UserLog userLog) {
        userLogMapper.insert(userLog);
    }

    /**
     * 修改
     * @param userLog
     */
    public void update(UserLog userLog) {
        userLogMapper.updateByPrimaryKeySelective(userLog);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        userLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(UserLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // user_id
            if(searchMap.get("userId")!=null && !"".equals(searchMap.get("userId"))){
                criteria.andLike("userId","%"+searchMap.get("userId")+"%");
            }
            // 操作者
            if(searchMap.get("operater")!=null && !"".equals(searchMap.get("operater"))){
                criteria.andLike("operater","%"+searchMap.get("operater")+"%");
            }
            // 操作内容
            if(searchMap.get("operating")!=null && !"".equals(searchMap.get("operating"))){
                criteria.andLike("operating","%"+searchMap.get("operating")+"%");
            }
            // 结果
            if(searchMap.get("result")!=null && !"".equals(searchMap.get("result"))){
                criteria.andLike("result","%"+searchMap.get("result")+"%");
            }


        }
        return example;
    }

}
