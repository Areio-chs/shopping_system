package com.shop.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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

	//处理不在数据库的字段
	@Transient
	private String name;

	@Transient
	private String img;

	private String userId;//用户id

	private String goodsId;//商品id

	private Integer num;//单个商品的数量

	private Double price;//单个商品乘以数量的价格

	private Integer checked;

	public Integer getChecked() {
		return checked;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", img='" + img + '\'' +
				", userId='" + userId + '\'' +
				", goodsId='" + goodsId + '\'' +
				", num=" + num +
				", price=" + price +
				", checked=" + checked +
				'}';
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
