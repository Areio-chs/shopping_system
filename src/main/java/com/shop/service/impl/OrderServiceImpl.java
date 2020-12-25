package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.OrderMapper;
import com.shop.pojo.*;
import com.shop.service.*;
import com.shop.utils.RandomIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StoreService storeService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    /**
     * 返回全部记录
     * @return
     */
    public List<Order> findAll() {
        return orderMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Order> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Order> orders = (Page<Order>) orderMapper.selectAll();
        return new PageResult<Order>(orders.getTotal(),orders.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Order> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return orderMapper.selectByExample(example);
    }
    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Order> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Order> orderList = (Page<Order>) orderMapper.selectByExample(example);
        for (Order order:orderList){
            if(!(order.getStoreId()==null)){
                Store store = storeService.findById(order.getStoreId());
                order.setStoreName(store.getName());
            }
            String status = order.getStatus();
            if (!(status==null)){
                if (status.equals("1")){
                    order.setStatusName("待付款");
                }
                if (status.equals("2")){
                    order.setStatusName("待发货");
                }
                if (status.equals("3")){
                    order.setStatusName("待收货");
                }
                if (status.equals("4")){
                    order.setStatusName("待评价");
                }
            }
            String paymentype = order.getPaymentype();
            if (!(paymentype==null)){
                if (paymentype.equals("1")){
                    order.setPaymentypeName("在线支付");
                }
                if (paymentype.equals("2")){
                    order.setPaymentypeName("货到付款");
                }
            }

            String buyerRate = order.getBuyerRate();
            if (!(buyerRate==null)){
                if (buyerRate.equals("1")){
                    order.setBuyerRateName("未评价");
                }
                if (buyerRate.equals("2")){
                    order.setPaymentypeName("已评价");
                }
            }
        }

        return new PageResult<Order>(orderList.getTotal(),orderList.getResult());
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Order> sfindPage(Map<String, Object> searchMap, int page, int size,String storeId) {
        PageHelper.startPage(page,size);
        Example example = createExample2(searchMap,storeId);
        Page<Order> orderList = (Page<Order>) orderMapper.selectByExample(example);
        for (Order order:orderList){
            String status = order.getStatus();
            if (!(status==null)){
                if (status.equals("1")){
                    order.setStatusName("待付款");
                }
                if (status.equals("2")){
                    order.setStatusName("待发货");
                }
                if (status.equals("3")){
                    order.setStatusName("待收货");
                }
                if (status.equals("4")){
                    order.setStatusName("待评价");
                }
            }
            String paymentype = order.getPaymentype();
            if (!(paymentype==null)){
                if (paymentype.equals("1")){
                    order.setPaymentypeName("在线支付");
                }
                if (paymentype.equals("0")){
                    order.setPaymentypeName("货到付款");
                }
            }

            String buyerRate = order.getBuyerRate();
            if (!(buyerRate==null)){
                if (buyerRate.equals("1")){
                    order.setBuyerRateName("未评价");
                }
                if (buyerRate.equals("2")){
                    order.setPaymentypeName("已评价");
                }
            }
        }

        return new PageResult<Order>(orderList.getTotal(),orderList.getResult());
    }

    private Example createExample2(Map<String, Object> searchMap,String storeId){
        Example example=new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("storeId",storeId);
        if(searchMap!=null){
            // 订单号
            if(searchMap.get("orderNum")!=null && !"".equals(searchMap.get("orderNum"))){
                criteria.andLike("orderNum","%"+searchMap.get("orderNum")+"%");
            }
        }
        return example;
    }
    public void delivery(String orderId){
        //把该订单的状态改成发货状态
        Order order = new Order();
        order.setId(orderId);
        order.setUpdated(new Date());
        order.setStatus("3");
        orderMapper.updateByPrimaryKeySelective(order);
    }
    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Order findById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param order
     */
    public Map<String,Object> add(Order order, List<Cart> cartList) {

        order.setUserName(userService.findById(order.getUserId()).getName());
        order.setTrackingName("天天快递");
        order.setFreight((double) 0);
        order.setTrackingNum(RandomIdUtils.getGuid());
        order.setOrderNum(RandomIdUtils.getGuid());
        order.setFreight(Double.valueOf(0));
        order.setStatus("1");
        order.setCreated(new Date());//订单创建时间
        String storeId="";
        //1.获取选中的购物车
        for (Cart cart:cartList) {
            if(!goodsService.deductionStock(cart.getGoodsId(),cart.getNum())){
                throw  new RuntimeException("库存不足！");
            };
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setId(RandomIdUtils.getUUID());
            orderDetail.setGoodsId(cart.getGoodsId());
            Goods goods = goodsService.findById(cart.getGoodsId());
            storeId = goods.getStoreId();
            orderDetail.setOrderId(order.getId());
            orderDetail.setIsReturn("1");
            orderDetail.setGoodsName(goods.getName());
            orderDetail.setImage(goods.getImg());
            orderDetail.setGoodsQuantity(cart.getNum());
            orderDetail.setGoodsPrice(goods.getPrice());
            orderDetail.setTotalMoney(goods.getPrice()*cart.getNum());
            orderDetail.setFreight(Double.valueOf(0));
            orderDetail.setPayMoney(orderDetail.getTotalMoney()+orderDetail.getFreight());
            orderDetailService.add(orderDetail);
            cartService.delete(cart.getId());
        }
        order.setPayMoney(order.getTotalMoney());
        order.setStoreId(storeId);
        System.out.println(order.toString());
        orderMapper.insert(order);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("oid",order.getId());
        map.put("ordersn",order.getOrderNum());
        map.put("money",order.getPayMoney());
        return map;
    }

    /**
     * 修改
     * @param order
     */
    public void update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 关联用户
            if(searchMap.get("userId")!=null && !"".equals(searchMap.get("userId"))){
                criteria.andEqualTo("userId",searchMap.get("userId"));
            }
            // 用户昵称
            if(searchMap.get("userName")!=null && !"".equals(searchMap.get("userName"))){
                criteria.andLike("userName","%"+searchMap.get("userName")+"%");
            }
            // 状态(1未付款/2已付款/3已发货/4已完成)
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 快递名称
            if(searchMap.get("trackingName")!=null && !"".equals(searchMap.get("trackingName"))){
                criteria.andLike("trackingName","%"+searchMap.get("trackingName")+"%");
            }
            // 快递运单号
            if(searchMap.get("trackingNum")!=null && !"".equals(searchMap.get("trackingNum"))){
                criteria.andLike("trackingNum","%"+searchMap.get("trackingNum")+"%");
            }
            // 支付类型，1、在线支付，2、货到付款
            if(searchMap.get("paymentype")!=null && !"".equals(searchMap.get("paymentype"))){
                criteria.andLike("paymentype","%"+searchMap.get("paymentype")+"%");
            }
            // 买家留言
            if(searchMap.get("message")!=null && !"".equals(searchMap.get("message"))){
                criteria.andLike("message","%"+searchMap.get("message")+"%");
            }
            // 订单号
            if(searchMap.get("orderNum")!=null && !"".equals(searchMap.get("orderNum"))){
                criteria.andEqualTo("orderNum",searchMap.get("orderNum"));
            }
            // 收货人
            if(searchMap.get("receiverContact")!=null && !"".equals(searchMap.get("receiverContact"))){
                criteria.andLike("receiverContact","%"+searchMap.get("receiverContact")+"%");
            }
            // 收货人手机
            if(searchMap.get("receiverMobile")!=null && !"".equals(searchMap.get("receiverMobile"))){
                criteria.andLike("receiverMobile","%"+searchMap.get("receiverMobile")+"%");
            }
            // 收货人地址
            if(searchMap.get("receiverAddress")!=null && !"".equals(searchMap.get("receiverAddress"))){
                criteria.andLike("receiverAddress","%"+searchMap.get("receiverAddress")+"%");
            }
            // 是否评价
            if(searchMap.get("buyerRate")!=null && !"".equals(searchMap.get("buyerRate"))){
                criteria.andLike("buyerRate","%"+searchMap.get("buyerRate")+"%");
            }
            // 关联商家
            if(searchMap.get("storeId")!=null && !"".equals(searchMap.get("storeId"))){
                criteria.andEqualTo("storeId",searchMap.get("storeId"));
            }

            // 数量合计
            if(searchMap.get("totalNum")!=null ){
                criteria.andEqualTo("totalNum",searchMap.get("totalNum"));
            }

        }
        return example;

    }

}
