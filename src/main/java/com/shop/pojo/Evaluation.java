package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * evaluation实体类
 * @author Administrator
 *
 */
@Table(name="tb_evaluation")
public class Evaluation implements Serializable{

	@Id
	private String id;//id


	

	private String goodsId;//商品id

	private String orderDetailId;//订单号

	private Integer grade;//星级

	private String content;//内容

	private String img;//图片

	private java.util.Date time;//评价时间

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public java.util.Date getTime() {
		return time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}


	
}
