package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * cart实体类
 * @author Administrator
 *
 */
@Table(name="tb_cart")
public class Cart implements Serializable{

	@Id
	private String id;//id


	

	private String userId;//用户id

	private String goodsId;//商品id

	private Integer num;//单个商品的数量

	private Double price;//单个商品乘以数量的价格

	
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

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


	
}
