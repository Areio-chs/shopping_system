package com.shop.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * orderDetail实体类
 * @author Administrator
 *
 */
@Table(name="tb_order_detail")
public class OrderDetail implements Serializable{

	@Id
	private String id;//id


	

	private String orderId;//订单id

	private String goodsId;//商品号

	private String goodsName;//商品名

	@Transient
	private String spec;
	@Transient
	private String orderNum;

	@Transient
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date created;//创建时间

	private String isReturn;//是否退货
	@Transient
	private String isReturnName;

	private String image;//图片地址



	private Integer goodsQuantity;//数量

	private Double goodsPrice;//商品单价

	private Double freight;//运费

	private Double totalMoney;//总金额

	private Double payMoney;//实付金额

	private String buyerRate;//是否评价

	@Transient
	private String commentContent;


	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public String getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(String isReturn) {
		this.isReturn = isReturn;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Integer getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(Integer goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
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

	public String getBuyerRate() {
		return buyerRate;
	}
	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}

	public String getIsReturnName() {
		return isReturnName;
	}

	public void setIsReturnName(String isReturnName) {
		this.isReturnName = isReturnName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
}
