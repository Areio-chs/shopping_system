package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * returnOrderDetail实体类
 * @author Administrator
 *
 */
@Table(name="tb_return_order_detail")
public class ReturnOrderDetail implements Serializable{

	@Id
	private String id;//id


	

	private String categoryId;//category_id

	private String orderId;//订单ID

	private String orderDetailId;//订单明细ID

	private String returnOrderId;//退货订单ID

	private String goodsId;//商品号

	private String goodsName;//商品名

	private Double goodsPrice;//单价

	private int  goodsQuantity;//数量

	private Double freight;//运费

	private Double totalMoney;//总金额

	private Double payMoney;//实付金额

	private String image;//image

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getReturnOrderId() {
		return returnOrderId;
	}
	public void setReturnOrderId(String returnOrderId) {
		this.returnOrderId = returnOrderId;
	}

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


	
}
