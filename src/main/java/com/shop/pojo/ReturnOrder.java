package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * returnOrder实体类
 * @author Administrator
 *
 */
@Table(name="tb_return_order")
public class ReturnOrder implements Serializable{

	@Id
	private String id;//服务单号


	

	private String orderId;//订单号

	private java.util.Date applyTime;//申请时间

	private String userId;//用户id

	private String userName;//用户账户

	private String linkman;//联系人

	private String linkmanMobile;//联系人手机

	private Integer returnMoney;//退款金额

	private String isReturnFreight;//是否退运费

	private String status;//申请状态

	private java.util.Date disposeTime;//处理时间

	private String returnCause;//退货退款原因

	private String evidence;//凭证图片

	private String description;//问题描述

	private String remark;//处理备注

	private String storeId;//处理人id

	
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

	public java.util.Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(java.util.Date applyTime) {
		this.applyTime = applyTime;
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

	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanMobile() {
		return linkmanMobile;
	}
	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}

	public Integer getReturnMoney() {
		return returnMoney;
	}
	public void setReturnMoney(Integer returnMoney) {
		this.returnMoney = returnMoney;
	}

	public String getIsReturnFreight() {
		return isReturnFreight;
	}
	public void setIsReturnFreight(String isReturnFreight) {
		this.isReturnFreight = isReturnFreight;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.Date getDisposeTime() {
		return disposeTime;
	}
	public void setDisposeTime(java.util.Date disposeTime) {
		this.disposeTime = disposeTime;
	}

	public String getReturnCause() {
		return returnCause;
	}
	public void setReturnCause(String returnCause) {
		this.returnCause = returnCause;
	}

	public String getEvidence() {
		return evidence;
	}
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}


	
}
