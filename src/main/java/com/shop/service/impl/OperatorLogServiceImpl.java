package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.OperatorLogMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.OperatorLog;
import com.shop.service.OperatorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class OperatorLogServiceImpl implements OperatorLogService {

    @Autowired
    private OperatorLogMapper operatorLogMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<OperatorLog> findAll() {
        return operatorLogMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<OperatorLog> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<OperatorLog> operatorLogs = (Page<OperatorLog>) operatorLogMapper.selectAll();
        return new PageResult<OperatorLog>(operatorLogs.getTotal(),operatorLogs.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<OperatorLog> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return operatorLogMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<OperatorLog> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<OperatorLog> operatorLogs = (Page<OperatorLog>) operatorLogMapper.selectByExample(example);
        return new PageResult<OperatorLog>(operatorLogs.getTotal(),operatorLogs.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public OperatorLog findById(String id) {
        return operatorLogMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param operatorLog
     */
    public void add(OperatorLog operatorLog) {
        operatorLogMapper.insert(operatorLog);
    }

    /**
     * 修改
     * @param operatorLog
     */
    public void update(OperatorLog operatorLog) {
        operatorLogMapper.updateByPrimaryKeySelective(operatorLog);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        operatorLogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(OperatorLog.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // 操作者
            if(searchMap.get("operater")!=null && !"".equals(searchMap.get("operater"))){
                criteria.andLike("operater","%"+searchMap.get("operater")+"%");
            }
            // 运营商id
            if(searchMap.get("operaterId")!=null && !"".equals(searchMap.get("operaterId"))){
                criteria.andLike("operaterId","%"+searchMap.get("operaterId")+"%");
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
