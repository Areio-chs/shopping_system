package com.shop.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
/**
 * order实体类
 * @author Administrator
 *
 */
@Table(name="tb_order")
public class Order implements Serializable{

	@Id
	private String id;//id


	

	private String userId;//关联用户

	private String userName;//用户昵称

	private String status;//状态(1未付款/2已付款/3已发货/4已完成)
	@Transient
	private String statusName;

	private Double freight;//订单总运费

	private String trackingName;//快递名称

	private String trackingNum;//快递运单号

	private Integer totalNum;//数量合计

	private Double totalMoney;//该订单总价

	private Double preMoney;//优惠金额

	private Double payMoney;//实际支付

	private String paymentype;//支付类型，1、在线支付，2、货到付款

	@Transient
	private String paymentypeName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date created;//创建时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date updated;//更新时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date paymenttime;//付款时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date sendtime;//发货时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date endtime;//交易完成时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private java.util.Date closetime;//交易关闭时间

	private String message;//买家留言

	private String orderNum;//订单号

	private String receiverContact;//收货人

	private String receiverMobile;//收货人手机

	private String receiverAddress;//收货人地址

	private String buyerRate;//是否评价
	@Transient
	private String buyerRateName;
	private String storeId;//关联商家
	@Transient
	private String storeName;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getTrackingName() {
		return trackingName;
	}
	public void setTrackingName(String trackingName) {
		this.trackingName = trackingName;
	}

	public String getTrackingNum() {
		return trackingNum;
	}
	public void setTrackingNum(String trackingNum) {
		this.trackingNum = trackingNum;
	}

	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getPreMoney() {
		return preMoney;
	}
	public void setPreMoney(Double preMoney) {
		this.preMoney = preMoney;
	}

	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public String getPaymentype() {
		return paymentype;
	}
	public void setPaymentype(String paymentype) {
		this.paymentype = paymentype;
	}

	public java.util.Date getCreated() {
		return created;
	}
	public void setCreated(java.util.Date created) {
		this.created = created;
	}

	public java.util.Date getUpdated() {
		return updated;
	}
	public void setUpdated(java.util.Date updated) {
		this.updated = updated;
	}

	public java.util.Date getPaymenttime() {
		return paymenttime;
	}
	public void setPaymenttime(java.util.Date paymenttime) {
		this.paymenttime = paymenttime;
	}

	public java.util.Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(java.util.Date sendtime) {
		this.sendtime = sendtime;
	}

	public java.util.Date getEndtime() {
		return endtime;
	}
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

	public java.util.Date getClosetime() {
		return closetime;
	}
	public void setClosetime(java.util.Date closetime) {
		this.closetime = closetime;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getReceiverContact() {
		return receiverContact;
	}
	public void setReceiverContact(String receiverContact) {
		this.receiverContact = receiverContact;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getBuyerRate() {
		return buyerRate;
	}
	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}

	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getPaymentypeName() {
		return paymentypeName;
	}

	public void setPaymentypeName(String paymentypeName) {
		this.paymentypeName = paymentypeName;
	}

	public String getBuyerRateName() {
		return buyerRateName;
	}

	public void setBuyerRateName(String buyerRateName) {
		this.buyerRateName = buyerRateName;
	}
}
