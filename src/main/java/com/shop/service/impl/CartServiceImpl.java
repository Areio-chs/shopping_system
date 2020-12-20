package com.shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shop.dao.CartMapper;
import com.shop.dao.GoodsMapper;
import com.shop.pojo.Category;
import com.shop.pojo.Goods;
import com.shop.pojo.PageResult;
import com.shop.pojo.Cart;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Cart> findAll() {
        return cartMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Cart> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Cart> carts = (Page<Cart>) cartMapper.selectAll();
        return new PageResult<Cart>(carts.getTotal(),carts.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Cart> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        List<Cart> cartList = cartMapper.selectByExample(example);
        for (Cart cart : cartList) {
            if (!(cart.getGoodsId()==null)){
                Goods goods = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
                cart.setName(goods.getName());
                cart.setImg(goods.getImg());
            }
        }
        return cartList;
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Cart> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Cart> carts = (Page<Cart>) cartMapper.selectByExample(example);
        return new PageResult<Cart>(carts.getTotal(),carts.getResult());
    }

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public Cart findById(String id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增
     * @param cart
     */
    public void add(Cart cart) {
        cartMapper.insert(cart);
    }

    /**
     * 修改
     * @param cart
     */
    public void update(Cart cart) {
        cartMapper.updateByPrimaryKeySelective(cart);
    }

    /**
     *  删除
     * @param id
     */
    public void delete(String id) {
        cartMapper.deleteByPrimaryKey(id);
    }

    public void updateChecked(String id, boolean checked) {
        Cart cart = cartMapper.selectByPrimaryKey(id);
            if (checked){
                cart.setChecked(1);
            }else {
                cart.setChecked(0);
            }
        cartMapper.updateByPrimaryKey(cart);
    }

    public void addItem(String id, Integer num) {
        Cart cart = cartMapper.selectByPrimaryKey(id);
        cart.setNum(cart.getNum()+num);
        if (cart.getNum()<=0){
            cartMapper.delete(cart);
            return;
        }
        cartMapper.updateByPrimaryKey(cart);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // id
            if(searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
                criteria.andEqualTo("id",searchMap.get("id"));
            }
            // 用户id
            if(searchMap.get("userId")!=null && !"".equals(searchMap.get("userId"))){
                criteria.andEqualTo("userId",searchMap.get("userId"));
            }
            // 商品id
            if(searchMap.get("goodsId")!=null && !"".equals(searchMap.get("goodsId"))){
                criteria.andEqualTo("goodsId",searchMap.get("goodsId"));
            }

            // 单个商品的数量
            if(searchMap.get("num")!=null ){
                criteria.andEqualTo("num",searchMap.get("num"));
            }

            // 单个商品的
            if(searchMap.get("checked")!=null ){
                criteria.andEqualTo("checked",searchMap.get("checked"));
            }

        }
        return example;
    }

}
