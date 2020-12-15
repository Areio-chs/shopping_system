package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.ReturnOrderDetailMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.ReturnOrderDetail;
import com.shop.service.ReturnOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class ReturnOrderDetailServiceImpl implements ReturnOrderDetailService {

    @Autowired
    private ReturnOrderDetailMapper returnOrderDetailMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<ReturnOrderDetail> findAll() {
        return returnOrderDetailMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<ReturnOrderDetail> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<ReturnOrderDetail> returnOrderDetails = (Page<ReturnOrderDetail>) returnOrderDetailMapper.selectAll();
        return new PageResult<ReturnOrderDetail>(returnOrderDetails.getTotal(),returnOrderDetails.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<ReturnOrderDetail> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return returnOrderDetailMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<ReturnOrderDetail> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<ReturnOrderDetail> returnOrderDetails = (Page<ReturnOrderDetail>) returnOrderDetailMapper.selectByExample(example);
        return new PageResult<ReturnOrderDetail>(returnOrderDetails.getTotal(),returnOrderDetails.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public ReturnOrderDetail findById(String id) {
        return returnOrderDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param returnOrderDetail
     */
    public void add(ReturnOrderDetail returnOrderDetail) {
        returnOrderDetailMapper.insert(returnOrderDetail);
    }

    /**
     * 修改
     * @param returnOrderDetail
     */
    public void update(ReturnOrderDetail returnOrderDetail) {
        returnOrderDetailMapper.updateByPrimaryKeySelective(returnOrderDetail);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        returnOrderDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(ReturnOrderDetail.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // category_id
            if(searchMap.get("categoryId")!=null && !"".equals(searchMap.get("categoryId"))){
                criteria.andLike("categoryId","%"+searchMap.get("categoryId")+"%");
            }
            // 订单ID
            if(searchMap.get("orderId")!=null && !"".equals(searchMap.get("orderId"))){
                criteria.andLike("orderId","%"+searchMap.get("orderId")+"%");
            }
            // 订单明细ID
            if(searchMap.get("orderDetailId")!=null && !"".equals(searchMap.get("orderDetailId"))){
                criteria.andLike("orderDetailId","%"+searchMap.get("orderDetailId")+"%");
            }
            // 退货订单ID
            if(searchMap.get("returnOrderId")!=null && !"".equals(searchMap.get("returnOrderId"))){
                criteria.andLike("returnOrderId","%"+searchMap.get("returnOrderId")+"%");
            }
            // 商品号
            if(searchMap.get("goodsId")!=null && !"".equals(searchMap.get("goodsId"))){
                criteria.andLike("goodsId","%"+searchMap.get("goodsId")+"%");
            }
            // 商品名
            if(searchMap.get("goodsName")!=null && !"".equals(searchMap.get("goodsName"))){
                criteria.andLike("goodsName","%"+searchMap.get("goodsName")+"%");
            }
            // image
            if(searchMap.get("image")!=null && !"".equals(searchMap.get("image"))){
                criteria.andLike("image","%"+searchMap.get("image")+"%");
            }

            // 数量
            if(searchMap.get("goodsQuantity")!=null ){
                criteria.andEqualTo("goodsQuantity",searchMap.get("goodsQuantity"));
            }

        }
        return example;
    }

}
