package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.OrderDetailMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.OrderDetail;
import com.shop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<OrderDetail> findAll() {
        return orderDetailMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<OrderDetail> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<OrderDetail> orderDetails = (Page<OrderDetail>) orderDetailMapper.selectAll();
        return new PageResult<OrderDetail>(orderDetails.getTotal(),orderDetails.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<OrderDetail> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return orderDetailMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<OrderDetail> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<OrderDetail> orderDetails = (Page<OrderDetail>) orderDetailMapper.selectByExample(example);
        return new PageResult<OrderDetail>(orderDetails.getTotal(),orderDetails.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public OrderDetail findById(String id) {
        return orderDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param orderDetail
     */
    public void add(OrderDetail orderDetail) {
        orderDetailMapper.insert(orderDetail);
    }

    /**
     * 修改
     * @param orderDetail
     */
    public void update(OrderDetail orderDetail) {
        orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        orderDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(OrderDetail.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andLike("id","%"+searchMap.get("id")+"%");
            }
            // 订单id
            if(searchMap.get("orderId")!=null && !"".equals(searchMap.get("orderId"))){
                criteria.andLike("orderId","%"+searchMap.get("orderId")+"%");
            }
            // 商品号
            if(searchMap.get("goodsId")!=null && !"".equals(searchMap.get("goodsId"))){
                criteria.andLike("goodsId","%"+searchMap.get("goodsId")+"%");
            }
            // 商品名
            if(searchMap.get("goodsName")!=null && !"".equals(searchMap.get("goodsName"))){
                criteria.andLike("goodsName","%"+searchMap.get("goodsName")+"%");
            }
            // 是否退货
            if(searchMap.get("isReturn")!=null && !"".equals(searchMap.get("isReturn"))){
                criteria.andLike("isReturn","%"+searchMap.get("isReturn")+"%");
            }
            // 图片地址
            if(searchMap.get("image")!=null && !"".equals(searchMap.get("image"))){
                criteria.andLike("image","%"+searchMap.get("image")+"%");
            }
            // 是否评价
            if(searchMap.get("buyerRate")!=null && !"".equals(searchMap.get("buyerRate"))){
                criteria.andLike("buyerRate","%"+searchMap.get("buyerRate")+"%");
            }

            // 数量
            if(searchMap.get("goodsQuantity")!=null ){
                criteria.andEqualTo("goodsQuantity",searchMap.get("goodsQuantity"));
            }

        }
        return example;
    }

}
