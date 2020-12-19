package com.shop.controller;


import com.shop.dao.OrderMapper;
import com.shop.pojo.*;
import com.shop.service.CartService;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import com.shop.utils.RandomIdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/findAll")
    public List<Cart> findAll(){
        return cartService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Cart> findPage(int page, int size){
        return cartService.findPage(page, size);
    }

    @PostMapping("/findList")
    public List<Cart> findList(@RequestBody Map<String,Object> searchMap){
        return cartService.findList(searchMap);
    }

    @PostMapping("/findPage")
    public PageResult<Cart> findPage(@RequestBody Map<String,Object> searchMap,int page, int size){
        return  cartService.findPage(searchMap,page,size);
    }

    @GetMapping("/findById")
    public Cart findById(String id){
        return cartService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody Cart cart){
        cartService.add(cart);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Cart cart){
        cartService.update(cart);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(String id){
        cartService.delete(id);
        return new Result();
    }

    @GetMapping("/buy")
    public void buy(HttpServletResponse response, String userId,String goodsId, Integer num,Double price) throws IOException {
        Cart cart = new Cart();
        cart.setId(RandomIdUtils.getUUID());
        cart.setGoodsId(goodsId);
        cart.setUserId(userId);
        cart.setNum(num);
        cart.setPrice(price);
        cartService.add(cart);
        response.sendRedirect("/cart.html");
    }

    @GetMapping("/updateChecked")
    public Result updateChecked(String id,boolean checked){
        cartService.updateChecked(id,checked);
        return new Result();
    }


    @GetMapping("/addItem")
    public Result addItem(String id,Integer num){
        cartService.addItem(id,num);
        return new Result();
    }

    /**
     * 保存订单
     * @param order
     * @return
     */
    @PostMapping("/saveOrder")
    public Map<String,Object> saveOrder(@RequestBody Order order,Map<String,Object> searchMap){
        order.setId(RandomIdUtils.getUUID());
        List<Cart> cartList = cartService.findList(searchMap);
        order.setUserId(cartList.get(0).getUserId());
        System.out.println(order.toString());
        return orderService.add(order, cartList);
    }

    /**
     * 删除选中的购物车
     * @return
     */
    @PostMapping("/deleteCheckedCart")
    public Result deleteCheckedCart(@RequestBody Map<String,Object> searchMap){
        List<Cart> cartList = cartService.findList(searchMap);
        for (Cart cart:cartList) {
            if (cart.getChecked()==1){
                cartService.delete(cart.getId());
            }
        }
        return new Result();
    }


}
